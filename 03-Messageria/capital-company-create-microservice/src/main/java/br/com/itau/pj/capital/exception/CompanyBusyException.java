package br.com.itau.pj.capital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.TOO_MANY_REQUESTS, reason = "Muitas solicitações, serviço indisponível. Tente novamente em alguns segundos.")
public class CompanyBusyException extends RuntimeException {
}