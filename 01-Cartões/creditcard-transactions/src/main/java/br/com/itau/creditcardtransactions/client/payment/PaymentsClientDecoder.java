package br.com.itau.creditcardtransactions.client.payment;

import br.com.itau.creditcardtransactions.exception.CreditCardNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.util.logging.Logger;

public class PaymentsClientDecoder implements ErrorDecoder {
    private final static Logger LOGGER = Logger.getLogger(PaymentsClientDecoder.class.getName());

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        LOGGER.warning(String.format("%s -> %s", response.status(), response.body()));

        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            throw new CreditCardNotFoundException();
        } else {
            return errorDecoder.decode(s, response);
        }
    }
}