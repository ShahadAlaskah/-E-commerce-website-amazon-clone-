package com.example.ecommercewebsite.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor @Data
public class AddProductToMerchantStock {
    @Size(min = 3 ,max = 3)
    @NotEmpty
    private String productID;

    @Size(min = 3 ,max = 3)
    @NotEmpty
    private String merchantID;

    @Range(min = 10)
    @NotNull
    private Integer stock;
}
