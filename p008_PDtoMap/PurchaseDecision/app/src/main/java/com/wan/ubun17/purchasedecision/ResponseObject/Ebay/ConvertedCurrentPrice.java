
package com.wan.ubun17.purchasedecision.ResponseObject.Ebay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ConvertedCurrentPrice {

    @SerializedName("@currencyId")
    @Expose
    private String currencyId;
    @SerializedName("__value__")
    @Expose
    private String value;

    /**
     * 
     * @return
     *     The currencyId
     */
    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * 
     * @param currencyId
     *     The @currencyId
     */
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The __value__
     */
    public void setValue(String value) {
        this.value = value;
    }

}
