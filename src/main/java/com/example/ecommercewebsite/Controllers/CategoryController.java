package com.example.ecommercewebsite.Controllers;

import com.example.ecommercewebsite.Model.ApiResponse;
import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/Category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategory());
    }

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(201).body( new ApiResponse("New category added !",201));
    }

    @PutMapping("/{index}")
    public ResponseEntity<?> updateCategory(@RequestBody @Valid Category category,@PathVariable int index,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        categoryService.updateCategory(index,category);
        return ResponseEntity.status(201).body( new ApiResponse("category updated !",201));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<?> deleteCategory(@PathVariable int index){
        categoryService.deleteCategory(index);
        return ResponseEntity.status(200).body(new ApiResponse("category deleted !",200));
    }
}
