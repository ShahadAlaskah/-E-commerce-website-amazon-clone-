package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.*;
import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class MyUserService {
    ArrayList<MyUser> myUserArrayList=new ArrayList<>();
    private final MerchantStockService merchantStockService;
    private final ProductService productService;

    public ArrayList<MyUser> getUsers() {
        return myUserArrayList;
    }
    public void addUser(MyUser myUser) {
        myUserArrayList.add(myUser);
    }

    public void updateUser(int index, MyUser myUser) {
        myUserArrayList.set(index,myUser);
    }

    public void deleteUser(int index) {
        myUserArrayList.remove(index);
    }

    public void addProductToMerchantStock(AddProductToMerchantStock addProductToMerchantStock) {
        ArrayList<MerchantStock> merchantStockArrayList=merchantStockService.getMerchantStock();
        for (int i = 0; i < merchantStockArrayList.size(); i++) {
            MerchantStock merchantStock=merchantStockArrayList.get(i);
            if (merchantStock.getProductID().equals(addProductToMerchantStock.getProductID())&&
            merchantStock.getMerchantID().equals(addProductToMerchantStock.getMerchantID())){
                MerchantStock newMerchantStock=new MerchantStock(merchantStock.getID(),merchantStock.getProductID(),merchantStock.getMerchantID(),(merchantStock.getStock()+addProductToMerchantStock.getStock()));
                merchantStockService.updateMerchantStock(i,newMerchantStock);
            }
        }
    }

    public boolean BuyProduct(BuyProduct buyProduct) {
        ArrayList<MerchantStock> merchantStockArrayList=merchantStockService.getMerchantStock();
        ArrayList<Product> productArrayList=productService.getProduct();


        for (int i = 0; i < merchantStockArrayList.size(); i++) {
            MerchantStock merchantStock=merchantStockArrayList.get(i);
            if (merchantStock.getProductID().equals(buyProduct.getProductID())&&
                    merchantStock.getMerchantID().equals(buyProduct.getMerchantID())){
                if (merchantStock.getStock() == 0) {
                    return false;
                }else {
                    for (int j = 0; j < myUserArrayList.size(); j++) {
                        MyUser myUser = myUserArrayList.get(j);
                        if (myUser.getID().equals(buyProduct.getUserID())) {
                            for (int e = 0; e < productArrayList.size(); e++) {
                                Product product = productArrayList.get(e);
                                if (product.getID().equals(buyProduct.getProductID())) {
                                    if (myUser.getBalance() >= product.getPrice()) {
                                        myUser.setBalance(myUser.getBalance() - product.getPrice());
                                        merchantStock.setStock(merchantStock.getStock() - 1);
                                        return true;
                                    }
                                }
                            }

                        }
                    }
                }

            }
        }
      return false;
    }
}

