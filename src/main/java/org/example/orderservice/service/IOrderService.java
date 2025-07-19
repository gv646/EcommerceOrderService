package org.example.orderservice.service;

import org.example.orderservice.dto.CreateOrderResponseDTO;
import org.example.orderservice.dto.OrderRequestDTO;

public interface IOrderService {
     CreateOrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);
}
