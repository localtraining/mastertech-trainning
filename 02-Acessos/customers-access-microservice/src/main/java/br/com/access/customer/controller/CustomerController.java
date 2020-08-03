package br.com.access.customer.controller;

import br.com.access.customer.model.Customer;
import br.com.access.customer.model.CustomerMapper;
import br.com.access.customer.model.dto.CustomerRequest;
import br.com.access.customer.model.dto.CustomerResponse;
import br.com.access.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper mapper;

    @GetMapping(value="/{id}")
    public Customer find(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse create(@RequestBody CustomerRequest customerRequest) {
        Customer customer = mapper.toCustomer(customerRequest);

        return mapper.fromCustomer(customerService.create(customer));
    }
}