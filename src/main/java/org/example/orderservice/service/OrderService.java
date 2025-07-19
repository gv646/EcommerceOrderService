package org.example.orderservice.service;

import org.example.orderservice.clients.ProductServiceClient;
import org.example.orderservice.dto.CreateOrderResponseDTO;
import org.example.orderservice.dto.OrderItemDTO;
import org.example.orderservice.dto.OrderRequestDTO;
import org.example.orderservice.dto.ProductDTO;
import org.example.orderservice.entity.Order;
import org.example.orderservice.entity.OrderItem;
import org.example.orderservice.enums.OrderStatus;
import org.example.orderservice.mappers.OrderItemMapper;
import org.example.orderservice.mappers.OrderMapper;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public OrderService(OrderRepository orderRepository, ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }


    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {

        Order order = OrderMapper.toOrderEntity(orderRequestDTO);

        List<OrderItem> orderItems = new ArrayList<>();

        for(OrderItemDTO orderItemDTO:orderRequestDTO.getItems()){
            ProductDTO product = productServiceClient.getProductById(orderItemDTO.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * orderItemDTO.getQuantity();
            OrderItem orderItem = OrderItemMapper.toOrderItemEntity(orderItemDTO,order,pricePerUnit,totalPrice);
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        Order createdOrder = orderRepository.save(order);

        return OrderMapper.toCreateOrderResponseDTO(createdOrder);
    }
}
