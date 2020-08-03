package br.com.access.customer.model;

import br.com.access.customer.model.dto.CustomerRequest;
import br.com.access.customer.model.dto.CustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());

        return customer;
    }

    public CustomerResponse fromCustomer(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());

        return customerResponse;
    }
}