package br.com.itau.creditcard.client;

import br.com.itau.creditcard.exception.CustomerServiceOfflineException;
import br.com.itau.creditcard.model.dto.Customer;

import java.util.Optional;

public class CustomerClientFallback implements CustomerClient {
    @Override
    public Optional<Customer> findCustomerById(Long id) {
        throw new CustomerServiceOfflineException();
    }
}