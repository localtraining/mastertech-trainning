package br.com.itau.creditcardtransactions.service;

import br.com.itau.creditcardtransactions.client.CreditCardCustomerClient;
import br.com.itau.creditcardtransactions.client.PaymentsClient;
import br.com.itau.creditcardtransactions.exception.CreditCardNotFoundException;
import br.com.itau.creditcardtransactions.model.Payment;
import br.com.itau.creditcardtransactions.model.dto.CreditCard;
import br.com.itau.creditcardtransactions.model.dto.CreditCardPayedTransactionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardTransactionsService {
    @Autowired
    private CreditCardCustomerClient creditCardCustomerClient;

    @Autowired
    private PaymentsClient paymentsClient;

    public List<Payment> findCreditCardCustomerById(Long clientId, Long creditCardId) {
        CreditCard creditCard = creditCardCustomerClient.findCreditCardCustomerById(creditCardId).orElseThrow(CreditCardNotFoundException::new);

        return paymentsClient.listByCreditCardId(creditCardId);
    }

    public CreditCardPayedTransactionsResponse payCardTransactions(Long creditCardId) {
        return paymentsClient.pay(creditCardId);
    }
}