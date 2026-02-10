package com.juliana_barreto.ecommerce.modules.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO implements Serializable {

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String cpf;

  // Password field - write-only for security purposes
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  public UserDTO(User entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.email = entity.getEmail();
    this.phone = entity.getPhone();
    this.cpf = entity.getCpf();
    // Password is intentionally not mapped from entity to DTO for security reasons
  }
}