package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Model.Category;
import com.example.ecommercewebsite.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    ArrayList<Merchant> merchantArrayList=new ArrayList<>();

    public ArrayList<Merchant> getMerchant() {
        return merchantArrayList;
    }
    public void addMerchant(Merchant merchant) {
        merchantArrayList.add(merchant);
    }

    public void updateMerchant(int index, Merchant merchant) {
        merchantArrayList.set(index,merchant);
    }

    public void deleteMerchant(int index) {
        merchantArrayList.remove(index);
    }
}
