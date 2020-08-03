package br.com.access.control.controlmicroservice.client;

import br.com.access.control.controlmicroservice.exception.CustomerNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.util.logging.Logger;

public class CustomerClientDecoder implements ErrorDecoder {
    private final static Logger LOGGER = Logger.getLogger(CustomerClientDecoder.class.getName());

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        LOGGER.warning(String.format("%s -> %s", response.status(), response.body()));

        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            throw new CustomerNotFoundException();
        } else {
            return errorDecoder.decode(s, response);
        }
    }
}