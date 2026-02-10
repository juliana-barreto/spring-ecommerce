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
@RequestMapping("/products")
@Tag(name = "Products", description = "Product management")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  @Operation(summary = "List all", description = "Returns the list of all registered products")
  public ResponseEntity<List<Product>> list() {
    return ResponseEntity.ok(productService.findAll());
  }

  @GetMapping("/{id}")
  @Operation(summary = "Find by ID", description = "Returns a specific product by its ID")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    return ResponseEntity.ok(productService.findById(id));
  }

  @PostMapping
  @Operation(summary = "Create product", description = "Creates a new product with categories")
  public ResponseEntity<Product> create(@RequestBody Product product) {
    Product newProduct = productService.create(product);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(newProduct.getId()).toUri();
    return ResponseEntity.created(uri).body(newProduct);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update product",
      description = "Updates product details and category associations")
  public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
    return ResponseEntity.ok(productService.update(id, product));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete product",
      description = "Removes a product (only if not linked to orders)")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}