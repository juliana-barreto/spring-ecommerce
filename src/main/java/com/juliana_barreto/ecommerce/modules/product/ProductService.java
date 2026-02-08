package com.juliana_barreto.ecommerce.modules.product;

import com.juliana_barreto.ecommerce.shared.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + id));
  }

  public Product create(Product product) {
    if (product.getName() == null || product.getName().isBlank()) {
      throw new IllegalArgumentException("Product name is mandatory.");
    }
    return productRepository.save(product);
  }

  public Product update(Long id, Product updatedProduct) {
    Product existingProduct = findById(id);

    // Update only if the field is not null
    if (updatedProduct.getName() != null && !updatedProduct.getName().isBlank()) {
      existingProduct.setName(updatedProduct.getName());
    }

    return productRepository.save(existingProduct);
  }

  public void delete(Long id) {
    if (!productRepository.existsById(id)) {
      throw new ResourceNotFoundException("Product not found for deletion.");
    }
    productRepository.deleteById(id);
  }
}
