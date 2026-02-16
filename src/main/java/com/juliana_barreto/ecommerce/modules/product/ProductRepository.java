package com.juliana_barreto.ecommerce.modules.product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("""
      SELECT DISTINCT p 
      FROM Product p 
      JOIN FETCH p.categories 
      WHERE p.id = :id
      """)
  Optional<Product> findByIdWithCategories(@Param("id") Long id);

  @Query("""
      SELECT DISTINCT p 
      FROM Product p 
      JOIN FETCH p.categories
      """)
  List<Product> findAllWithCategories();
}
