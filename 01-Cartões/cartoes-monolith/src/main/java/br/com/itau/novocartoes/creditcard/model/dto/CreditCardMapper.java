package br.com.itau.novocartoes.creditcard.model.dto;

import br.com.itau.novocartoes.creditcard.model.CreditCard;
import br.com.itau.novocartoes.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {
    public CreditCard toCreditCard(CreateCreditCardRequest createCreditCardRequest) {
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(createCreditCardRequest.getNumber());

        Customer customer = new Customer();
        customer.setId(createCreditCardRequest.getCustomerId());
        creditCard.setCustomer(customer);

        return creditCard;
    }

    public CreateCreditCardResponse toCreateCreditCardResponse(CreditCard creditCard) {
        CreateCreditCardResponse createCreditCardResponse = new CreateCreditCardResponse();

        createCreditCardResponse.setId(creditCard.getId());
        createCreditCardResponse.setNumber(creditCard.getNumber());
        createCreditCardResponse.setCustomerId(creditCard.getCustomer().getId());
        createCreditCardResponse.setActive(creditCard.getActive());

        return createCreditCardResponse;
    }

    public CreditCard toCreditCard(UpdateCreditCardRequest updateCreditCardRequest) {
        CreditCard creditCard = new CreditCard();

        creditCard.setNumber(updateCreditCardRequest.getNumber());
        creditCard.setActive(updateCreditCardRequest.getActive());

        return creditCard;
    }

    public UpdateCreditCardResponse toUpdateCreditCardResponse(CreditCard creditCard) {
        UpdateCreditCardResponse updateCreditCardResponse = new UpdateCreditCardResponse();

        updateCreditCardResponse.setId(creditCard.getId());
        updateCreditCardResponse.setNumber(creditCard.getNumber());
        updateCreditCardResponse.setCustomerId(creditCard.getCustomer().getId());
        updateCreditCardResponse.setActive(creditCard.getActive());

        return updateCreditCardResponse;
    }

    public GetCreditCardResponse toGetCreditCardResponse(CreditCard creditCard) {
        GetCreditCardResponse getCreditCardResponse = new GetCreditCardResponse();

        getCreditCardResponse.setId(creditCard.getId());
        getCreditCardResponse.setNumber(creditCard.getNumber());
        getCreditCardResponse.setCustomerId(creditCard.getCustomer().getId());

        return getCreditCardResponse;
    }
}