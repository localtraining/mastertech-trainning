package br.com.itau.customer.model;

import br.com.itau.customer.model.Customer;
import br.com.itau.customer.model.dto.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());

        return customer;
    }
}