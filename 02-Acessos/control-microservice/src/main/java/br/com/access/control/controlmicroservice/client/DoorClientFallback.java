package br.com.access.control.controlmicroservice.client;

import br.com.access.control.controlmicroservice.exception.CustomerServiceOfflineException;
import br.com.access.control.controlmicroservice.exception.DoorServiceOfflineException;
import br.com.access.control.controlmicroservice.model.Control;
import br.com.access.control.controlmicroservice.model.Customer;
import br.com.access.control.controlmicroservice.model.Door;

import java.util.Optional;

public class DoorClientFallback implements DoorClient {
    @Override
    public Optional<Door> find(Long id) {
        throw new DoorServiceOfflineException();
    }
}