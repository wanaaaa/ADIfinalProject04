package com.wan.ubun17.purchasedecision.ResponseObject.BestBuyObject;

import java.util.ArrayList;

/**
 * Created by wanmac on 9/12/16.
 */
public class BestBuyObject {
    private ArrayList<Products> products;

    public ArrayList<Products> getProductses() {
        return products;
    }

    public void setProductses(ArrayList<Products> arg) {
        this.products = arg;
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
