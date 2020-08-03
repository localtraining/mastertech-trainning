package br.com.itau.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "Serviço de cartão de crédito offline")
public class CreditCardServiceOfflineException extends RuntimeException{
}