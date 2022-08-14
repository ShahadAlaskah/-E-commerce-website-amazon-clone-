package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categoryArrayList=new ArrayList<>();

    public ArrayList<Category> getCategory() {
        return categoryArrayList;
    }
    public void addCategory(Category category) {
        categoryArrayList.add(category);
    }

    public void updateCategory(int index, Category category) {
        categoryArrayList.set(index,category);
    }

    public void deleteCategory(int index) {
        categoryArrayList.remove(index);
    }
}
