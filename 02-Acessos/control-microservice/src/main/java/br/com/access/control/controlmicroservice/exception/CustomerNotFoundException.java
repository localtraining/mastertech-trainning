package br.com.access.control.controlmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cliente não encontrado")
public class CustomerNotFoundException extends RuntimeException {
}