package br.com.access.customer.service;

import br.com.access.customer.exception.CustomerNotFoundException;
import br.com.access.customer.model.Customer;
import br.com.access.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
}