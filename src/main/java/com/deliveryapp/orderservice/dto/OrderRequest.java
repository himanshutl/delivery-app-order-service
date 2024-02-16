package com.deliveryapp.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private long userId;
    private List<FoodItemDto> foodItemsList;
    private RestaurantDto restaurantDto;

}
