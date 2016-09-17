package com.wan.ubun17.purchasedecision.ResponseObject.BestBuyObject;

/**
 * Created by wanmac on 9/12/16.
 */
public class Products {
    private String salePrice;

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String num) {
        this.salePrice = num;
    }

    @Override
    public String toString() {
        return salePrice;
    }
}
