package com.example.ecommercewebsite.Controllers;

import com.example.ecommercewebsite.Model.AddProductToMerchantStock;
import com.example.ecommercewebsite.Model.ApiResponse;
import com.example.ecommercewebsite.Model.BuyProduct;
import com.example.ecommercewebsite.Model.MyUser;
import com.example.ecommercewebsite.Service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/User")
@AllArgsConstructor
public class MyUserController {

    private final MyUserService myUserService;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.status(200).body(myUserService.getUsers());
    }

    @PostMapping
    public  ResponseEntity<?> addUser(@RequestBody @Valid MyUser myUser, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        myUserService.addUser(myUser);
        return ResponseEntity.status(201).body( new ApiResponse("New user added !",201));
    }

    @PutMapping("/{index}")
    public  ResponseEntity<?> updateUser(@RequestBody @Valid MyUser myUser, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        myUserService.updateUser(index,myUser);
        return ResponseEntity.status(201).body( new ApiResponse("User updated !",201));
    }

    @DeleteMapping("/{index}")
    public  ResponseEntity<?> deleteUser(@PathVariable int index){
        myUserService.deleteUser(index);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted !",200));
    }

    @PostMapping("/addProductToMerchantStock")
    public  ResponseEntity<?>  addProductToMerchantStock(@RequestBody @Valid AddProductToMerchantStock addProductToMerchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        myUserService.addProductToMerchantStock(addProductToMerchantStock);
        return ResponseEntity.status(201).body( new ApiResponse("Add Product To a MerchantStock !",201));
    }
    @PostMapping("/buyProduct")
    public  ResponseEntity<?>  BuyProduct(@RequestBody @Valid BuyProduct buyProduct, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        boolean isValid = myUserService.BuyProduct(buyProduct);
        if (isValid == true) {
            return ResponseEntity.status(201).body( new ApiResponse("Buy Product !",201));
        }else {
            return ResponseEntity.status(201).body( new ApiResponse("Bad Request !",201));
        }
    }
}
