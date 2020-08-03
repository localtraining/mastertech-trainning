package br.com.itau.creditcardtransactions.client;

import br.com.itau.creditcardtransactions.model.Payment;
import br.com.itau.creditcardtransactions.model.dto.CreditCardPayedTransactionsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="payment-microservice", configuration = PaymentsClientConfiguration.class)
public interface PaymentsClient {
    @GetMapping("/pagamentos/{creditCardId}")
    List<Payment> listByCreditCardId(@PathVariable Long creditCardId);

    @PatchMapping(value="/pagar/{creditCardId}")
    public CreditCardPayedTransactionsResponse pay(@PathVariable Long creditCardId);
}
