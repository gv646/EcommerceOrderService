package org.example.orderservice.dto;

import lombok.*;
import org.example.orderservice.enums.OrderStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateOrderStatusDTO {
    private Long orderId;
    private OrderStatus status;
}
