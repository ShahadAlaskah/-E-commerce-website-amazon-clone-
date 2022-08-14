package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.MyUser;
import com.example.ecommercewebsite.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> productArrayList=new ArrayList<>();

    public ArrayList<Product> getProduct() {
        return productArrayList;
    }
    public void addProduct(Product product) {
        productArrayList.add(product);
    }

    public void updateProduct(int index, Product product) {
        productArrayList.set(index,product);
    }

    public void deleteProduct(int index) {
        productArrayList.remove(index);
    }
}
