package com.example.ecommercewebsite.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Merchant {
    @Size(min = 3 ,max = 3)
    @NotEmpty
    private String ID;

    @Size(min = 3 ,max = 3)
    @NotEmpty
    private String name;
}
