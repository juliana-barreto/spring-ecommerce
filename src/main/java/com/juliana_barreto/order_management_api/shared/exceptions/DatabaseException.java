package com.juliana_barreto.order_management_api.shared.exceptions;

public class DatabaseException extends RuntimeException {

  public DatabaseException(String message) {
    super(message);
  }
}
