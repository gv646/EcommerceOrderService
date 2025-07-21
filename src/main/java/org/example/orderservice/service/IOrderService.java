package org.example.orderservice.service;

import org.example.orderservice.dto.CreateOrderResponseDTO;
import org.example.orderservice.dto.OrderRequestDTO;
import org.example.orderservice.dto.UpdateOrderStatusDTO;

public interface IOrderService {

     CreateOrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

     CreateOrderResponseDTO updateOrderStatus(UpdateOrderStatusDTO updateOrderStatusDTO) throws Exception;
}
