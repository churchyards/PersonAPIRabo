package nl.lakkermans.personapi.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Person's first and last name combination isn't unique.")
public class PersonNotUniqueException extends RuntimeException {
}
