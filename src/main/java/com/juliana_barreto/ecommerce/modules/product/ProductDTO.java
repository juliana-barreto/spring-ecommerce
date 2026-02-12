package com.juliana_barreto.ecommerce.modules.product;

import com.juliana_barreto.ecommerce.modules.category.Category;
import com.juliana_barreto.ecommerce.modules.category.CategoryDTO;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDTO implements Serializable {

  private Long id;

  @NotBlank(message = "Product name is mandatory and cannot be blank.")
  private String name;

  private String description;

  @NotNull(message = "Price is mandatory.")
  @DecimalMin(value = "0.01", message = "Price must be positive.")
  private BigDecimal price;

  private String imgUrl;
  @NotEmpty(message = "Product must belong to at least one category.")
  private Set<CategoryDTO> categories = new HashSet<>();

  public ProductDTO(Product entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.price = entity.getPrice();
    this.imgUrl = entity.getImgUrl();

    // Convert categories from entity to DTOs
    if (entity.getCategories() != null) {
      for (Category cat : entity.getCategories()) {
        CategoryDTO dto = new CategoryDTO(cat);
        this.categories.add(dto);
      }
    }
  }
}