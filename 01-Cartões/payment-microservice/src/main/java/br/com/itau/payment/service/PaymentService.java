package br.com.itau.payment.service;

import br.com.itau.payment.client.CreditCardClient;
import br.com.itau.payment.exception.CreditCardNotFoundException;
import br.com.itau.payment.model.Payment;
import br.com.itau.payment.model.dto.CreditCard;
import br.com.itau.payment.model.dto.PayedTransactionsResponse;
import br.com.itau.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CreditCardClient creditCardClient;

    public List<Payment> listByCreditCardId(Long creditCardId) {
        return paymentRepository.findByCreditCardId(creditCardId);
    }

    public List<Payment> listNotPayedByCreditCardId(Long creditCardId) {
        return paymentRepository.findByCreditCardIdAndPayedIsNull(creditCardId);
    }

    public Payment create(Payment payment) {
        CreditCard creditCard = creditCardClient.findCreditCardCustomerById(payment.getCreditCardId()).orElseThrow(CreditCardNotFoundException::new);

        return paymentRepository.save(payment);
    }

    public PayedTransactionsResponse payCard(Long creditCardId) {
        CreditCard creditCard = creditCardClient.findCreditCardCustomerById(creditCardId).orElseThrow(CreditCardNotFoundException::new);

        List<Payment> payments = paymentRepository.findByCreditCardId(creditCardId).stream()
                .filter(item -> item.getPayed() == null || !item.getPayed())
                .map(transaction -> {
                    transaction.setPayed(true);
                    transaction.setPayedDate(LocalDateTime.now());

                    return transaction;
                })
                .collect(Collectors.toList());

        PayedTransactionsResponse response = new PayedTransactionsResponse();

        if(!payments.isEmpty()) {

            paymentRepository.saveAll(payments);

            response.setId(creditCardId);
            response.setPayedDate(LocalDate.now());
            response.setValue(payments.stream()
                    .map(Payment::getValue)
                    .reduce(BigDecimal::add)
                    .get());
        }

        return response;
    }
}