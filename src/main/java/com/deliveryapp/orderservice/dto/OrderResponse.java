package com.deliveryapp.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private long orderId;
    private List<FoodItemDto> foodItemList;
    private UserDto userDto;
    private RestaurantDto restaurantDto;

}
