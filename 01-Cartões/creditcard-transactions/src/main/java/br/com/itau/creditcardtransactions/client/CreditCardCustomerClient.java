package br.com.itau.creditcardtransactions.client;

import br.com.itau.creditcardtransactions.model.dto.CreditCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="creditcard-microservice", configuration = CreditCardCustomerClientConfiguration.class)
public interface CreditCardCustomerClient {
    @GetMapping("/cartao/{id}")
    Optional<CreditCard> findCreditCardCustomerById(@PathVariable Long id);
}
