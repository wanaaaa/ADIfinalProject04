
package com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class WalMartSearch {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("responseGroup")
    @Expose
    private String responseGroup;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("start")
    @Expose
    private Integer start;
    @SerializedName("numItems")
    @Expose
    private Integer numItems;
    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();
    @SerializedName("facets")
    @Expose
    private List<Object> facets = new ArrayList<Object>();

    /**
     * 
     * @return
     *     The query
     */
    public String getQuery() {
        return query;
    }

    /**
     * 
     * @param query
     *     The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * 
     * @return
     *     The sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * 
     * @param sort
     *     The sort
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 
     * @return
     *     The responseGroup
     */
    public String getResponseGroup() {
        return responseGroup;
    }

    /**
     * 
     * @param responseGroup
     *     The responseGroup
     */
    public void setResponseGroup(String responseGroup) {
        this.responseGroup = responseGroup;
    }

    /**
     * 
     * @return
     *     The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The totalResults
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * 
     * @return
     *     The start
     */
    public Integer getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The numItems
     */
    public Integer getNumItems() {
        return numItems;
    }

    /**
     * 
     * @param numItems
     *     The numItems
     */
    public void setNumItems(Integer numItems) {
        this.numItems = numItems;
    }

    /**
     * 
     * @return
     *     The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The facets
     */
    public List<Object> getFacets() {
        return facets;
    }

    /**
     * 
     * @param facets
     *     The facets
     */
    public void setFacets(List<Object> facets) {
        this.facets = facets;
    }

}
