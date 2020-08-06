package br.com.itau.pj.capital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cliente não encontrado")
public class CompanyNotFoundException extends RuntimeException {
}