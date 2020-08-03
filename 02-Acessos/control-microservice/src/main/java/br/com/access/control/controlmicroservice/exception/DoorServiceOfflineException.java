package br.com.access.control.controlmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "Serviço de controle de portas indisponível")
public class DoorServiceOfflineException extends RuntimeException {
}