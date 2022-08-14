package com.example.ecommercewebsite.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class MyUser {
//    id ( must not be empty , have to be 3 character long ).
//    username ( must not be empty , have to be 5 length long ).
//    password ( must not be empty , have to be 6 length long , must have characters and digits ).
//    email ( must not be empty , must be valid email ).
//    role ( must not be empty , have to be in ( “Admin”,”Customer”) ).
//    balance ( must not be empty , have to be positive ).

    @Size(min = 3 ,max = 3)
    @NotEmpty
    private String ID;

    @Size(min = 5)
    @NotEmpty
    private String username;

    @Size(min = 6)
    @NotEmpty
    //@Pattern(regexp = "/^(?:[0-9]+[a-z]|[a-z]+[0-9])[a-z0-9]*$/i")
    private String password;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    @Pattern(regexp = "(admin|user)",message = "Role must be in admin or user only")
    private String role;

    @Positive
    @NotNull
    private double balance;



}
