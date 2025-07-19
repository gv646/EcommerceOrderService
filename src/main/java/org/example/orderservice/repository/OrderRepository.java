package org.example.orderservice.repository;

import org.example.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
