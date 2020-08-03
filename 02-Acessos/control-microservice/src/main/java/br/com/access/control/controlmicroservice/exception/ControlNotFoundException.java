package br.com.access.control.controlmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Acesso não liberado")
public class ControlNotFoundException extends RuntimeException {
}