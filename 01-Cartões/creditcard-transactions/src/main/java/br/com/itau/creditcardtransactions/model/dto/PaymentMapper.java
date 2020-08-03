package br.com.itau.creditcardtransactions.model.dto;

import br.com.itau.creditcardtransactions.model.Payment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMapper {
    public List<CreditCardTransactionsResponse> toCreditCardTransactionsResponse(List<Payment> payment) {
        return payment.stream().map(item -> {
            CreditCardTransactionsResponse response = new CreditCardTransactionsResponse();

            response.setId(item.getId());
            response.setDescription(item.getDescription());
            response.setCreditCardId(item.getCreditCardId());
            response.setValue(item.getValue());

            return response;
        }).collect(Collectors.toList());
    }
}
