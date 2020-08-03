package br.com.access.control.controlmicroservice.client;

import br.com.access.control.controlmicroservice.exception.CustomerServiceOfflineException;
import br.com.access.control.controlmicroservice.model.Customer;

import java.util.Optional;

public class CustomerClientFallback implements CustomerClient {
    @Override
    public Optional<Customer> find(Long id) {
        throw new CustomerServiceOfflineException();
    }
}