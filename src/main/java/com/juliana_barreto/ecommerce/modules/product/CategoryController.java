package com.juliana_barreto.ecommerce.modules.product;

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
@RequestMapping("/categories")
@Tag(name = "Categories", description = "Category management")
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  @Operation(summary = "List all", description = "Returns the list of all registered categories")
  public ResponseEntity<List<Category>> list() {
    return ResponseEntity.ok(categoryService.findAll());
  }

  @GetMapping("/{id}")
  @Operation(summary = "Find by ID", description = "Returns a specific category by its ID")
  public ResponseEntity<Category> findById(@PathVariable Long id) {
    return ResponseEntity.ok(categoryService.findById(id));
  }

  @PostMapping
  @Operation(summary = "Create category", description = "Creates a new category")
  public ResponseEntity<Category> create(@RequestBody Category category) {
    Category newCategory = categoryService.create(category);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(newCategory.getId()).toUri();
    return ResponseEntity.created(uri).body(newCategory);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update category", description = "Updates category status")
  public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
    return ResponseEntity.ok(categoryService.update(id, category));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete category", description = "Removes a category from the database")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    categoryService.delete(id);
    return ResponseEntity.noContent().build();
  }
}