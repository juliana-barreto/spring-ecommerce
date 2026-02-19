package com.juliana_barreto.order_management_api.shared.exceptions;

public class BusinessException extends RuntimeException {

  public BusinessException(String message) {
    super(message);
  }
}
