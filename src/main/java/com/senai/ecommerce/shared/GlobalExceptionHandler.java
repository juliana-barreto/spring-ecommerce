package com.senai.ecommerce.shared;

import com.senai.ecommerce.shared.exceptions.InvalidDataException;
import com.senai.ecommerce.shared.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // Handling for ERROR 404
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> resourceNotFound(
      ResourceNotFoundException ex, HttpServletRequest request) {

    ErrorResponse error = new ErrorResponse(
        LocalDateTime.now(),
        HttpStatus.NOT_FOUND.value(),
        "Resource not found",
        ex.getMessage(),
        request.getRequestURI()
    );

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  // Handling for ERROR 400
  @ExceptionHandler(InvalidDataException.class)
  public ResponseEntity<ErrorResponse> invalidData(
      InvalidDataException ex, HttpServletRequest request) {

    ErrorResponse error = new ErrorResponse(
        LocalDateTime.now(),
        HttpStatus.BAD_REQUEST.value(),
        "Invalid data",
        ex.getMessage(),
        request.getRequestURI()
    );

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  // Handling for ERROR 500
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> exception(
      Exception ex, HttpServletRequest request) {

    ErrorResponse error = new ErrorResponse(
        LocalDateTime.now(),
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        "Internal server error",
        ex.getMessage(),
        request.getRequestURI()
    );

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
