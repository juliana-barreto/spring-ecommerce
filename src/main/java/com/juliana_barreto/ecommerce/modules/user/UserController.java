package com.juliana_barreto.ecommerce.modules.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "Users", description = "User management")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  @Operation(summary = "List all", description = "Returns the list of all registered users")
  public ResponseEntity<List<User>> list() {
    return ResponseEntity.ok(userService.findAll());
  }

  @GetMapping("/{id}")
  @Operation(summary = "Find by ID", description = "Returns a specific user by their ID")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findById(id));
  }

  @PostMapping
  @Operation(summary = "Create user", description = "Creates a new user")
  public ResponseEntity<User> create(@RequestBody User user) {
    User newUser = userService.create(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(newUser.getId()).toUri();
    return ResponseEntity.created(uri).body(newUser);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update user", description = "Updates only the provided data, keeping the rest")
  public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
    return ResponseEntity.ok(userService.update(id, user));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete user", description = "Removes a user from the database")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
