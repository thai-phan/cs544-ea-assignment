package bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(AlreadyExistsException.class)
  public ResponseEntity<Object> handleBookAlreadyExists(AlreadyExistsException ex, WebRequest request) {
    Map<String, Object> body = new HashMap<>();
    body.put("isSuccess", false);
    body.put("error", ex.getMessage());
    body.put("status", HttpStatus.CONFLICT);
    return new ResponseEntity<>(body, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(value = { Exception.class})
  public ResponseEntity<Object> handleConflict(Exception exception, WebRequest request) {
    Map<String, Object> map = new HashMap<>();
    map.put("isSuccess", false);
    map.put("error", exception.getMessage());
    map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}