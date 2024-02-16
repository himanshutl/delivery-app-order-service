package com.deliveryapp.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String userName;
    private String userPassword;
    private String address;
    private String city;
}

