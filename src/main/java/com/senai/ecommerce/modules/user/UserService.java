package com.senai.ecommerce.modules.user;

import com.senai.ecommerce.shared.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
  }

  public User create(User user) {
    if (user.getName() == null || user.getName().isBlank()) {
      throw new IllegalArgumentException("User name is mandatory.");
    }
    if (user.getCpf() == null || user.getCpf().isBlank()) {
      throw new IllegalArgumentException("User CPF is mandatory.");
    }
    return userRepository.save(user);
  }

  public User update(Long id, User updatedUser) {
    User existingUser = findById(id);

    // Update only if the field is not null
    if (updatedUser.getName() != null && !updatedUser.getName().isBlank()) {
      existingUser.setName(updatedUser.getName());
    }
    if (updatedUser.getEmail() != null && !updatedUser.getEmail().isBlank()) {
      existingUser.setEmail(updatedUser.getEmail());
    }

    return userRepository.save(existingUser);
  }

  public void delete(Long id) {
    if (!userRepository.existsById(id)) {
      throw new ResourceNotFoundException("User not found for deletion.");
    }
    userRepository.deleteById(id);
  }
}
