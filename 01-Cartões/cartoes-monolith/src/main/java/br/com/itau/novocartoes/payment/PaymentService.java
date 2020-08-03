package br.com.itau.novocartoes.payment;

import br.com.itau.novocartoes.creditcard.model.CreditCard;
import br.com.itau.novocartoes.creditcard.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> listByCreditCardId(Long creditCardId) {
        return paymentRepository.findByCreditCardId(creditCardId);
    }

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }
}