package br.com.itau.payment.client;

import br.com.itau.payment.exception.CreditCardServiceOfflineException;
import br.com.itau.payment.model.dto.CreditCard;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class CreditCardFallback implements CreditCardClient {
    @Override
    public Optional<CreditCard> findCreditCardCustomerById(@PathVariable Long id) {
        throw new CreditCardServiceOfflineException();
    }
}