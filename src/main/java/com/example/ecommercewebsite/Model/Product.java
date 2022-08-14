package com.example.ecommercewebsite.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Product {
//    id ( must not be empty , have to be 3 character long ).
//    name ( must not be empty , have to be 3 length long ).
//    price ( must not be empty , must be positive number ).
//    categoryID ( must not be empty , have to be 3 character long ).
    @Size(min = 3 ,max = 3)
   @NotEmpty
   private String ID;

    @Size(min = 3 ,max = 3)
    @NotEmpty
   private String name;

    @Positive
    @NotNull
   private double price;

    @Size(min = 3 ,max = 3)
    @NotEmpty
   private String categoryID;
}
