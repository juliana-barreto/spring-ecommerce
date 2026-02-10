package com.juliana_barreto.ecommerce.modules.order_item;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderItemDTO implements Serializable {

  private Long productId;
  private String productName;
  private String productImgUrl;
  private Integer quantity;
  private BigDecimal unitPrice;
  private BigDecimal subTotal;

  public OrderItemDTO(OrderItem entity) {
    this.productId = entity.getProduct().getId();
    this.productName = entity.getProduct().getName();
    this.productImgUrl = entity.getProduct().getImgUrl();
    this.quantity = entity.getQuantity();
    this.unitPrice = entity.getUnitPrice();
    this.subTotal = entity.getSubTotal();
  }
}