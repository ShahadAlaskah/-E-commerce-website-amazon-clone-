package com.example.ecommercewebsite.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class BuyProduct {

    @Size(min = 3 ,max = 3)
    @NotEmpty
    private String userID;

    @Size(min = 3 ,max = 3)
    @NotEmpty
    private String productID;

    @Size(min = 3 ,max = 3)
    @NotEmpty
    private String merchantID;
}
