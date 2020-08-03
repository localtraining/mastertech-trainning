package br.com.access.doors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Porta não localizada")
public class DoorNotFoundException extends RuntimeException {
}
