package br.com.itau.creditcard.controller;

import br.com.itau.creditcard.client.CustomerClientDecoder;
import br.com.itau.creditcard.model.CreditCard;
import br.com.itau.creditcard.model.dto.*;
import br.com.itau.creditcard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@RequestMapping("/cartao")
public class CreditCardController {
    private final static Logger LOGGER = Logger.getLogger(CreditCardController.class.getName());

    @Autowired
    public CreditCardService creditCardService;

    @Autowired
    private CreditCardMapper mapper;

    @GetMapping("/{id}")
    public CreditCard findCreditCardByNumber(@PathVariable Long id) {
        LOGGER.warning(String.format("findCreditCardByNumber -> %s", id));

        return creditCardService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCreditCardResponse createCreditCard(@Valid @RequestBody CreateCreditCardRequest creditCardRequest) {
        CreditCard creditCard = mapper.toCreditCard(creditCardRequest);

        CreateCreditCardResponse creditCardResponse = mapper.toCreateCreditCardResponse(creditCardService.create(creditCard));

        return creditCardResponse;
    }

    @PatchMapping("/{creditCardNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public UpdateCreditCardResponse updateCreditCard(@PathVariable String creditCardNumber, @RequestBody UpdateCreditCardRequest creditCardRequest) {
        creditCardRequest.setNumber(creditCardNumber);
        CreditCard creditCard = mapper.toCreditCard(creditCardRequest);

        creditCard = creditCardService.update(creditCard);

        return mapper.toUpdateCreditCardResponse(creditCard);
    }
}