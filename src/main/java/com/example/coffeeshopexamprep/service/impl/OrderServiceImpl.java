package com.example.coffeeshopexamprep.service.impl;

import com.example.coffeeshopexamprep.model.entity.Order;
import com.example.coffeeshopexamprep.model.service.OrderServiceModel;
import com.example.coffeeshopexamprep.model.view.OrderViewModel;
import com.example.coffeeshopexamprep.repository.OrderRepository;
import com.example.coffeeshopexamprep.service.CategoryService;
import com.example.coffeeshopexamprep.service.OrderService;
import com.example.coffeeshopexamprep.service.UserService;
import com.example.coffeeshopexamprep.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CurrentUser currentUser;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService, CurrentUser currentUser) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.currentUser = currentUser;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrdersByPriceDesc() {
        return orderRepository
                .findAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order,OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
