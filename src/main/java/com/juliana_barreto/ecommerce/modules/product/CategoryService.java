package com.juliana_barreto.ecommerce.modules.product;

import com.juliana_barreto.ecommerce.shared.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(Long id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));
  }

  public Category create(Category category) {
    if (category.getName() == null || category.getName().isBlank()) {
      throw new IllegalArgumentException("Category name is mandatory.");
    }
    return categoryRepository.save(category);
  }

  public Category update(Long id, Category updatedCategory) {
    Category existingCategory = findById(id);

    // Update only if the field is not null
    if (updatedCategory.getName() != null && !updatedCategory.getName().isBlank()) {
      existingCategory.setName(updatedCategory.getName());
    }

    return categoryRepository.save(existingCategory);
  }

  public void delete(Long id) {
    if (!categoryRepository.existsById(id)) {
      throw new ResourceNotFoundException("Category not found for deletion.");
    }
    categoryRepository.deleteById(id);
  }
}
