
package com.wan.ubun17.purchasedecision.ResponseObject.Ebay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class SearchResult {

    @SerializedName("@count")
    @Expose
    private String count;
    @SerializedName("item")
    @Expose
    private List<Item> item = new ArrayList<Item>();

    /**
     * 
     * @return
     *     The count
     */
    public String getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The @count
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The item
     */
    public List<Item> getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    public void setItem(List<Item> item) {
        this.item = item;
    }

}
