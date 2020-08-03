package br.com.itau.novocartoes.creditcard;

import br.com.itau.novocartoes.creditcard.model.CreditCard;
import br.com.itau.novocartoes.customer.model.Customer;
import br.com.itau.novocartoes.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CustomerService customerService;

    public CreditCard create(CreditCard creditCard) {
        Customer customer = customerService.findById(creditCard.getCustomer().getId());

        creditCard.setCustomer(customer);
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