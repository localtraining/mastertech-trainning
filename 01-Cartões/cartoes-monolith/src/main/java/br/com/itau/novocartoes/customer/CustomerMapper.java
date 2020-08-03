package br.com.itau.novocartoes.customer;

import br.com.itau.novocartoes.customer.model.Customer;
import br.com.itau.novocartoes.customer.model.dto.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());

        return customer;
    }
}