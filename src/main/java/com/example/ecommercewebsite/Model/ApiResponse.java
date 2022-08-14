package com.example.ecommercewebsite.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ApiResponse {
    private String massage;
    private int error;
}
