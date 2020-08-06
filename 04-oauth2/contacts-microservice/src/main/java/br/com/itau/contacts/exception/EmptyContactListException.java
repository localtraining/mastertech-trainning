package br.com.itau.contacts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não existem contatos a serem listados para o usuário informado")
public class EmptyContactListException extends RuntimeException {
}
