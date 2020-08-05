package br.com.access.control.controlmicroservice.service;

import br.com.access.control.controlmicroservice.client.customer.CustomerClient;
import br.com.access.control.controlmicroservice.client.door.DoorClient;
import br.com.access.control.controlmicroservice.exception.ControlNotFoundException;
import br.com.access.control.controlmicroservice.exception.CustomerNotFoundException;
import br.com.access.control.controlmicroservice.exception.DoorNotFoundException;
import br.com.access.control.controlmicroservice.model.Control;
import br.com.access.control.controlmicroservice.model.Customer;
import br.com.access.control.controlmicroservice.model.Door;
import br.com.access.control.controlmicroservice.producer.AccessLoggerMapper;
import br.com.access.control.controlmicroservice.producer.AccessProducer;
import br.com.access.control.controlmicroservice.repository.ControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlService {
    @Autowired
    private ControlRepository controlRepository;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private DoorClient doorClient;

    @Autowired
    private AccessProducer accessProducer;

    @Autowired
    private AccessLoggerMapper accessLoggerMapper;

    public Control get(Long customerId, Long doorId) {
        Control control = controlRepository.findByCustomerIdAndDoorId(customerId, doorId).orElseThrow(ControlNotFoundException::new);

        accessProducer.sendKafkaLogMessage(accessLoggerMapper.fromControl(control));

        return control;
    }

    public void delete(Long customerId, Long doorId) {
        Control control = controlRepository.findByCustomerIdAndDoorId(customerId, doorId).orElseThrow(ControlNotFoundException::new);

        controlRepository.delete(control);
    }

    public Control grant(Control control) {
        return controlRepository.save(findCustomerAndDoor(control.getCustomerId(), control.getDoorId()));
    }

    private Control findCustomerAndDoor(Long customerId, Long doorId) {
        Customer customer = customerClient.find(customerId).orElseThrow(CustomerNotFoundException::new);

        Door door = doorClient.find(doorId).orElseThrow(DoorNotFoundException::new);

        Control control = new Control(customer.getId(), door.getId());

        controlRepository.findByCustomerIdAndDoorId(control.getCustomerId(), control.getDoorId()).ifPresent(
                foundControl -> {
                    control.setId(foundControl.getId());
                });

        return control;
    }
}