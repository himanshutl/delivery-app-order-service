package com.deliveryapp.orderservice.entity;

import com.deliveryapp.orderservice.dto.FoodItemDto;
import com.deliveryapp.orderservice.dto.RestaurantDto;
import com.deliveryapp.orderservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {
    private long orderId;
    private List<FoodItemDto> foodItemList;
    private RestaurantDto restaurant;
    private UserDto user;
}
