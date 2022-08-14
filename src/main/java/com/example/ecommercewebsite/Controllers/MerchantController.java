package com.example.ecommercewebsite.Controllers;

import com.example.ecommercewebsite.Model.ApiResponse;
import com.example.ecommercewebsite.Model.Merchant;
import com.example.ecommercewebsite.Service.MerchantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/Merchant")
@AllArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    @GetMapping
    public ResponseEntity getMerchant(){
        return ResponseEntity.status(200).body(merchantService.getMerchant());
    }

    @PostMapping
    public ResponseEntity<?> addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(201).body( new ApiResponse("New merchant added !",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity<?> updateMerchant(@RequestBody @Valid Merchant merchant, @PathVariable int index, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        merchantService.updateMerchant(index,merchant);
        return ResponseEntity.status(201).body( new ApiResponse("merchant updated !",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<?> deleteMerchant(@PathVariable int index){
        merchantService.deleteMerchant(index);
        return ResponseEntity.status(200).body(new ApiResponse("merchant deleted !",200));
    }
}
