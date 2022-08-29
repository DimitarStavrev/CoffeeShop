package com.example.coffeeshopexamprep.service;

import com.example.coffeeshopexamprep.model.service.OrderServiceModel;
import com.example.coffeeshopexamprep.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersByPriceDesc();

    void readyOrder(Long id);
}
