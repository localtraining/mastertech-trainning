package br.com.access.control.controlmicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Porta não localizada")
public class DoorNotFoundException extends RuntimeException {
}