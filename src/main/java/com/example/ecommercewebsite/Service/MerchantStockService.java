package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStockArrayList=new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStock() {
        return merchantStockArrayList;
    }
    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStockArrayList.add(merchantStock);
    }

    public void updateMerchantStock(int index, MerchantStock merchantStock) {
        merchantStockArrayList.set(index,merchantStock);
    }

    public void deleteMerchantStock(int index) {
        merchantStockArrayList.remove(index);
    }
}
