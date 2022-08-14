package com.example.ecommercewebsite.Controllers;

import com.example.ecommercewebsite.Model.ApiResponse;
import com.example.ecommercewebsite.Model.MerchantStock;
import com.example.ecommercewebsite.Model.MyUser;
import com.example.ecommercewebsite.Service.MerchantStockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/MerchantStock")
@AllArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    @GetMapping
    public ResponseEntity<?> getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStock());
    }

    @PostMapping
    public ResponseEntity<?> addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(201).body( new ApiResponse("New merchantStock added !",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity<?> updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantStockService.updateMerchantStock(index,merchantStock);
        return ResponseEntity.status(201).body( new ApiResponse("merchantStock updated !",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<?> deleteMerchantStock(@PathVariable int index){
        merchantStockService.deleteMerchantStock(index);
        return ResponseEntity.status(200).body(new ApiResponse("merchantStock deleted !",200));
    }
}
