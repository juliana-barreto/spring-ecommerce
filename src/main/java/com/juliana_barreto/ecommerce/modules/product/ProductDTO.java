package com.juliana_barreto.ecommerce.modules.product;

import com.juliana_barreto.ecommerce.modules.category.Category;
import com.juliana_barreto.ecommerce.modules.category.CategoryDTO;
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
  private String name;
  private String description;
  private BigDecimal price;
  private String imgUrl;
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