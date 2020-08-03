package br.com.itau.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cartão não encontrado.")
public class CreditCardNotFoundException extends RuntimeException{
}