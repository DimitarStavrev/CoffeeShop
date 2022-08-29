package com.example.coffeeshopexamprep.repository;

import com.example.coffeeshopexamprep.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByOrderByPriceDesc();
}
