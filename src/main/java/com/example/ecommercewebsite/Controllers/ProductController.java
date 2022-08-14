package com.example.ecommercewebsite.Controllers;

import com.example.ecommercewebsite.Model.ApiResponse;


import com.example.ecommercewebsite.Model.Product;
import com.example.ecommercewebsite.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/Product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getProduct(){
        return ResponseEntity.status(200).body(productService.getProduct());
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody @Valid Product product, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        productService.addProduct(product);
        return ResponseEntity.status(201).body( new ApiResponse("New Product added !",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity<?> updateProduct(@RequestBody @Valid Product product, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        productService.updateProduct(index,product);
        return ResponseEntity.status(201).body( new ApiResponse("Product updated !",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<?> deleteProduct(@PathVariable int index){
        productService.deleteProduct(index);
        return ResponseEntity.status(200).body(new ApiResponse("Product deleted !",200));
    }
}
