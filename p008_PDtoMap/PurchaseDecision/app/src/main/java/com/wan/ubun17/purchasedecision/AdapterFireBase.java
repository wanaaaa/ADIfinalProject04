package com.wan.ubun17.purchasedecision;

/**
 * Created by ubun17 on 9/10/16.
 */
public class AdapterFireBase {
    private String mName, mPrice, mImageUrl, mFireReference ;

    AdapterFireBase() {}

    public AdapterFireBase(String str, String price, String url) {
        mName = str;
        mPrice = price;
        mImageUrl = url;
        mFireReference = "???";
    }

//    public String getItemName() {
//        return mName;
//    }

    public String getmName() {
        return mName;
    }

    public String  getmPrice(){
        return mPrice;
    }


    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmFireReference() {return mFireReference;}

    public void setmFireReference(String str) {
        mFireReference = str;
    }


}
