package com.deliveryapp.orderservice.service;

import com.deliveryapp.orderservice.dto.OrderRequest;
import com.deliveryapp.orderservice.dto.OrderResponse;
import com.deliveryapp.orderservice.dto.UserDto;
import com.deliveryapp.orderservice.entity.Order;
import com.deliveryapp.orderservice.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private SequenceGenerator sequenceGenerator;
    private ModelMapper modelMapper;
    private RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, SequenceGenerator sequenceGenerator, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.sequenceGenerator = sequenceGenerator;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    public OrderResponse saveOrderInDb(OrderRequest orderRequest) {
        Long orderId = sequenceGenerator.generateNextOrderId();

        UserDto userDto = fetchUserDetailsFromUserId(orderRequest.getUserId());

        Order orderToBeSaved = new Order(
                orderId,
                orderRequest.getFoodItemsList(),
                orderRequest.getRestaurantDto(),
                userDto
        );

        return modelMapper.map(orderRepository.save(orderToBeSaved), OrderResponse.class);
    }

    private UserDto fetchUserDetailsFromUserId(long userId) {
        return restTemplate.getForObject("https://USER-SERVICE/user/fetchUserById"+userId,
                UserDto.class);
    }
}
