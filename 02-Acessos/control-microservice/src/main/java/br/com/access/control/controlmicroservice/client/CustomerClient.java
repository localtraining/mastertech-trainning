package br.com.access.control.controlmicroservice.client;

import br.com.access.control.controlmicroservice.model.Customer;
import br.com.access.control.controlmicroservice.model.Door;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="customers-access-microservice", configuration = CustomerClientConfiguration.class)
public interface CustomerClient {
    @GetMapping("/cliente/{id}")
    Optional<Customer> find(@PathVariable Long id);
}