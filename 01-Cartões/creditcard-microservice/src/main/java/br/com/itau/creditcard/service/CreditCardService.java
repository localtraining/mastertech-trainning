package br.com.itau.creditcard.service;

import br.com.itau.creditcard.repository.CreditCardRepository;
import br.com.itau.creditcard.client.CustomerClient;
import br.com.itau.creditcard.exception.CreditCardNotFoundException;
import br.com.itau.creditcard.exception.CustomerNotFoundException;
import br.com.itau.creditcard.model.CreditCard;
import br.com.itau.creditcard.model.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CustomerClient customerClient;

    public CreditCard create(CreditCard creditCard) {
        Customer customer = customerClient.findCustomerById(creditCard.getCustomerId()).orElseThrow(CustomerNotFoundException::new);
        creditCard.setActive(false);

        return creditCardRepository.save(creditCard);
    }

    public CreditCard update(CreditCard creditCard) {
        CreditCard savedCreditCard = findByNumber(creditCard.getNumber());

        savedCreditCard.setActive(creditCard.getActive());

        return creditCardRepository.save(savedCreditCard);
    }

    public CreditCard findByNumber(String number) {
        return creditCardRepository.findByNumber(number).orElseThrow(CreditCardNotFoundException::new);
    }

    public CreditCard findById(Long id) {
        return creditCardRepository.findById(id).orElseThrow(CreditCardNotFoundException::new);
    }
}