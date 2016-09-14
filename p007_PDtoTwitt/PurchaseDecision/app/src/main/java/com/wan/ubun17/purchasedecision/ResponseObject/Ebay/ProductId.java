
package com.wan.ubun17.purchasedecision.ResponseObject.Ebay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProductId {

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("__value__")
    @Expose
    private String value;

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The @type
     */
    public void setType(String type) {
        this.type = type;
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
