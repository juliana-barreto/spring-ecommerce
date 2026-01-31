package com.senai.ecommerce.modules.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senai.ecommerce.modules.order.Order;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false, unique = true)
  private String phone;

  @Column(nullable = false, unique = true, length = 11)
  private String cpf;

  @Column(nullable = false)
  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Order> orders = new ArrayList<>();
}
