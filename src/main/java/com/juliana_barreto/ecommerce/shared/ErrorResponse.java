package com.juliana_barreto.ecommerce.shared;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record ErrorResponse(
    LocalDateTime timestamp,
    Integer status,
    String error,
    String message,
    String path,
    List<FieldMessage> errors
) {

  public ErrorResponse(
      LocalDateTime timestamp, Integer status, String error, String message, String path) {
    this(timestamp, status, error, message, path, new ArrayList<>());
  }
}
