package br.com.access.control.controlmicroservice.service;

import br.com.access.control.controlmicroservice.client.CustomerClient;
import br.com.access.control.controlmicroservice.client.DoorClient;
import br.com.access.control.controlmicroservice.exception.CustomerNotFoundException;
import br.com.access.control.controlmicroservice.exception.DoorNotFoundException;
import br.com.access.control.controlmicroservice.model.Control;
import br.com.access.control.controlmicroservice.model.Customer;
import br.com.access.control.controlmicroservice.model.Door;
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

    public Control grant(Control control) {
        return controlRepository.save(findCustomer(control));
    }

    public Control get(Long customerId, Long doorId) {
        return controlRepository.findByCustomerIdAndDoorId(customerId, doorId);
    }

    private Control findCustomer(Control control) {
        Customer customer = customerClient.find(control.getCustomerId()).orElseThrow(CustomerNotFoundException::new);

        Door door = doorClient.find(control.getDoorId()).orElseThrow(DoorNotFoundException::new);

        return new Control(customer.getId(), door.getId());
    }
}