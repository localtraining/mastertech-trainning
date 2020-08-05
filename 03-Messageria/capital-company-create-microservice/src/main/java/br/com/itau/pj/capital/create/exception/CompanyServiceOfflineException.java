package br.com.itau.pj.capital.create.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "Serviço de clientes indisponível")
public class CompanyServiceOfflineException extends RuntimeException {
}