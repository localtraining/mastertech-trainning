package br.com.itau.novocartoes.customer;

import br.com.itau.novocartoes.customer.model.Customer;
import br.com.itau.novocartoes.customer.model.dto.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/cliente/{id}")
    public Customer find(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping(value="/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody CustomerRequest cliente) {
        return customerService.create(cliente);
    }
}