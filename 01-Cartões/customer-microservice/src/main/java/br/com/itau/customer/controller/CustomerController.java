package br.com.itau.customer.controller;

import br.com.itau.customer.model.CustomerMapper;
import br.com.itau.customer.service.CustomerService;
import br.com.itau.customer.model.Customer;
import br.com.itau.customer.model.dto.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper mapper;

    @GetMapping(value="/cliente/{id}")
    public Customer find(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping(value="/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody CustomerRequest customerRequest) {
        Customer customer = mapper.toCustomer(customerRequest);

        return customerService.create(customer);
    }
}