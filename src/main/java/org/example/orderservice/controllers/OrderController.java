package org.example.orderservice.controllers;

import org.example.orderservice.dto.CreateOrderResponseDTO;
import org.example.orderservice.dto.OrderRequestDTO;
import org.example.orderservice.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        CreateOrderResponseDTO responseDTO = orderService.createOrder(orderRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }

}
