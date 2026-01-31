package com.senai.ecommerce.shared;

import java.time.LocalDateTime;

public record ErrorResponse(
    LocalDateTime timestamp,
    Integer status,
    String error,
    String message,
    String path
) {

}
