package br.com.itau.creditcard.client;

import br.com.itau.creditcard.model.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="customer-microservice", configuration = CustomerClientConfiguration.class)
public interface CustomerClient {
    @GetMapping("/cliente/{id}")
    Optional<Customer> findCustomerById(@PathVariable Long id);
}