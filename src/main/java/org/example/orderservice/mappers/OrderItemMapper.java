package org.example.orderservice.mappers;


import org.example.orderservice.dto.OrderItemDTO;
import org.example.orderservice.entity.Order;
import org.example.orderservice.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItem toOrderItemEntity(OrderItemDTO orderItemDTO, Order order, double pricePerUnit, double totalPrice) {
        return OrderItem.builder()
                .productId(orderItemDTO.getProductId())
                .quantity(orderItemDTO.getQuantity())
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }
}
