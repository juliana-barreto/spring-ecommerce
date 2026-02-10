package com.juliana_barreto.ecommerce.modules.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.juliana_barreto.ecommerce.modules.order_item.OrderItem;
import com.juliana_barreto.ecommerce.modules.order_item.OrderItemDTO;
import com.juliana_barreto.ecommerce.modules.user.UserDTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDTO implements Serializable {

  private Long id;

  @JsonFormat(shape = JsonFormat.Shape.STRING,
      pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
  private Instant moment;

  private OrderStatus status;
  private UserDTO client;
  private List<OrderItemDTO> items = new ArrayList<>();
  private BigDecimal total;

  public OrderDTO(Order entity) {
    this.id = entity.getId();
    this.moment = entity.getMoment();
    this.status = entity.getStatus();
    this.client = new UserDTO(entity.getClient()); //
    this.total = entity.getTotal();

    // Convert order items from entity to DTO
    if (entity.getItems() != null) {
      this.items = new ArrayList<>();

      for (OrderItem itemEntity : entity.getItems()) {
        this.items.add(new OrderItemDTO(itemEntity));
      }
    }
  }
}