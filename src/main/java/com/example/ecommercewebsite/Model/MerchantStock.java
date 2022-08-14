package com.example.ecommercewebsite.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@AllArgsConstructor @Data
public class MerchantStock {
//    id ( must not be empty , have to be 3 character long ).
//    productid ( must not be empty , have to be 3 character long ).
//    merchantid ( must not be empty , have to be 3 length long ).
//    stock ( must not be empty , have to be more than 10 at start ).
@Size(min = 3 ,max = 3)
@NotEmpty
private String ID;

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
