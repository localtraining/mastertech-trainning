package br.com.itau.payment.client;

import br.com.itau.payment.exception.CreditCardNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.util.logging.Logger;

public class CreditCardClientDecoder implements ErrorDecoder {
    private final static Logger LOGGER = Logger.getLogger(CreditCardClientDecoder.class.getName());

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