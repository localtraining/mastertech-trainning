package br.com.itau.payment.client;

import br.com.itau.payment.model.dto.CreditCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="creditcard-microservice", configuration = OAuth2FeignConfiguration.class)
public interface CreditCardClient {
    @GetMapping("/cartao/{id}")
    Optional<CreditCard> findCreditCardCustomerById(@PathVariable Long id);
}