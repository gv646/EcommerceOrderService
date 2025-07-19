package org.example.orderservice.dto;


import lombok.*;
import org.example.orderservice.enums.OrderStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderResponseDTO {
    private Long orderId;
    private OrderStatus status;
}
