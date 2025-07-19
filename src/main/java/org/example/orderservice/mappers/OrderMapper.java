package org.example.orderservice.mappers;

import org.example.orderservice.dto.CreateOrderResponseDTO;
import org.example.orderservice.dto.OrderRequestDTO;
import org.example.orderservice.entity.Order;
import org.example.orderservice.enums.OrderStatus;

public class OrderMapper {

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order order) {
        return CreateOrderResponseDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }

    public static Order toOrderEntity(OrderRequestDTO orderRequestDTO) {
        return Order.builder()
                .userId(orderRequestDTO.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }
}
