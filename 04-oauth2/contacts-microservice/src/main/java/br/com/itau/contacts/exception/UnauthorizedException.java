package br.com.itau.contacts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Acesso não autorizado")
public class UnauthorizedException extends RuntimeException {
}
