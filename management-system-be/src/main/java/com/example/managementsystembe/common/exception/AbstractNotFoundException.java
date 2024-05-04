package com.example.managementsystembe.common.exception;

public abstract class AbstractNotFoundException extends RuntimeException {

  public AbstractNotFoundException(String message) {
    super(message);
  }
}
