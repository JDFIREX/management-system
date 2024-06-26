package com.example.managementsystembe.common.rest;

import com.example.managementsystembe.common.exception.AbstractNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({AbstractNotFoundException.class})
  public final ResponseEntity<Object> handleNotFoundException(Exception ex) {
    ApiErrorResponse response = new ApiErrorResponse(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({IllegalArgumentException.class})
  public final ResponseEntity<Object> handleIllegalArgumentException(Exception ex) {
    ApiErrorResponse response = new ApiErrorResponse(ex.getMessage());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({Exception.class})
  public final ResponseEntity<Object> handleUncaughtExceptions(Exception ex) {
    ApiErrorResponse response = new ApiErrorResponse(ex.getMessage());
    log.error("Unhandled exception during REST endpoint call", ex);
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
