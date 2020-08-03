package br.com.itau.payment.model.dto;

import br.com.itau.payment.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment toPayment(PaymentRequest paymentRequest) {
       Payment payment = new Payment();

       payment.setCreditCardId(paymentRequest.getCreditCardId());
       payment.setDescription(paymentRequest.getDescription());
       payment.setValue(paymentRequest.getValue());

       return payment;
    }
}
