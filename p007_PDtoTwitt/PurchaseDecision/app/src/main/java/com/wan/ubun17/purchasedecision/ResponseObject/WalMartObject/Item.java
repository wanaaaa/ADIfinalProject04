
package com.wan.ubun17.purchasedecision.ResponseObject.WalMartObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Item {

    @SerializedName("itemId")
    @Expose
    private Integer itemId;
    @SerializedName("parentItemId")
    @Expose
    private Integer parentItemId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("msrp")
    @Expose
    private Double msrp;
    @SerializedName("salePrice")
    @Expose
    private Double salePrice;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("categoryPath")
    @Expose
    private String categoryPath;
    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;
    @SerializedName("longDescription")
    @Expose
    private String longDescription;
    @SerializedName("thumbnailImage")
    @Expose
    private String thumbnailImage;
    @SerializedName("mediumImage")
    @Expose
    private String mediumImage;
    @SerializedName("largeImage")
    @Expose
    private String largeImage;
    @SerializedName("productTrackingUrl")
    @Expose
    private String productTrackingUrl;
    @SerializedName("standardShipRate")
    @Expose
    private Double standardShipRate;
    @SerializedName("marketplace")
    @Expose
    private Boolean marketplace;
    @SerializedName("modelNumber")
    @Expose
    private String modelNumber;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("customerRating")
    @Expose
    private String customerRating;
    @SerializedName("numReviews")
    @Expose
    private Integer numReviews;
    @SerializedName("customerRatingImage")
    @Expose
    private String customerRatingImage;
    @SerializedName("categoryNode")
    @Expose
    private String categoryNode;
    @SerializedName("bundle")
    @Expose
    private Boolean bundle;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("addToCartUrl")
    @Expose
    private String addToCartUrl;
    @SerializedName("affiliateAddToCartUrl")
    @Expose
    private String affiliateAddToCartUrl;
    @SerializedName("giftOptions")
    @Expose
    private GiftOptions giftOptions;
    @SerializedName("imageEntities")
    @Expose
    private List<ImageEntity> imageEntities = new ArrayList<ImageEntity>();
    @SerializedName("offerType")
    @Expose
    private String offerType;
    @SerializedName("shippingPassEligible")
    @Expose
    private Boolean shippingPassEligible;
    @SerializedName("availableOnline")
    @Expose
    private Boolean availableOnline;

    /**
     * 
     * @return
     *     The itemId
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 
     * @param itemId
     *     The itemId
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 
     * @return
     *     The parentItemId
     */
    public Integer getParentItemId() {
        return parentItemId;
    }

    /**
     * 
     * @param parentItemId
     *     The parentItemId
     */
    public void setParentItemId(Integer parentItemId) {
        this.parentItemId = parentItemId;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The msrp
     */
    public Double getMsrp() {
        return msrp;
    }

    /**
     * 
     * @param msrp
     *     The msrp
     */
    public void setMsrp(Double msrp) {
        this.msrp = msrp;
    }

    /**
     * 
     * @return
     *     The salePrice
     */
    public Double getSalePrice() {
        return salePrice;
    }

    /**
     * 
     * @param salePrice
     *     The salePrice
     */
    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 
     * @return
     *     The upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     * 
     * @param upc
     *     The upc
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /**
     * 
     * @return
     *     The categoryPath
     */
    public String getCategoryPath() {
        return categoryPath;
    }

    /**
     * 
     * @param categoryPath
     *     The categoryPath
     */
    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    /**
     * 
     * @return
     *     The shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * 
     * @param shortDescription
     *     The shortDescription
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * 
     * @return
     *     The longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * 
     * @param longDescription
     *     The longDescription
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * 
     * @return
     *     The thumbnailImage
     */
    public String getThumbnailImage() {
        return thumbnailImage;
    }

    /**
     * 
     * @param thumbnailImage
     *     The thumbnailImage
     */
    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    /**
     * 
     * @return
     *     The mediumImage
     */
    public String getMediumImage() {
        return mediumImage;
    }

    /**
     * 
     * @param mediumImage
     *     The mediumImage
     */
    public void setMediumImage(String mediumImage) {
        this.mediumImage = mediumImage;
    }

    /**
     * 
     * @return
     *     The largeImage
     */
    public String getLargeImage() {
        return largeImage;
    }

    /**
     * 
     * @param largeImage
     *     The largeImage
     */
    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    /**
     * 
     * @return
     *     The productTrackingUrl
     */
    public String getProductTrackingUrl() {
        return productTrackingUrl;
    }

    /**
     * 
     * @param productTrackingUrl
     *     The productTrackingUrl
     */
    public void setProductTrackingUrl(String productTrackingUrl) {
        this.productTrackingUrl = productTrackingUrl;
    }

    /**
     * 
     * @return
     *     The standardShipRate
     */
    public Double getStandardShipRate() {
        return standardShipRate;
    }

    /**
     * 
     * @param standardShipRate
     *     The standardShipRate
     */
    public void setStandardShipRate(Double standardShipRate) {
        this.standardShipRate = standardShipRate;
    }

    /**
     * 
     * @return
     *     The marketplace
     */
    public Boolean getMarketplace() {
        return marketplace;
    }

    /**
     * 
     * @param marketplace
     *     The marketplace
     */
    public void setMarketplace(Boolean marketplace) {
        this.marketplace = marketplace;
    }

    /**
     * 
     * @return
     *     The modelNumber
     */
    public String getModelNumber() {
        return modelNumber;
    }

    /**
     * 
     * @param modelNumber
     *     The modelNumber
     */
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    /**
     * 
     * @return
     *     The productUrl
     */
    public String getProductUrl() {
        return productUrl;
    }

    /**
     * 
     * @param productUrl
     *     The productUrl
     */
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    /**
     * 
     * @return
     *     The customerRating
     */
    public String getCustomerRating() {
        return customerRating;
    }

    /**
     * 
     * @param customerRating
     *     The customerRating
     */
    public void setCustomerRating(String customerRating) {
        this.customerRating = customerRating;
    }

    /**
     * 
     * @return
     *     The numReviews
     */
    public Integer getNumReviews() {
        return numReviews;
    }

    /**
     * 
     * @param numReviews
     *     The numReviews
     */
    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    /**
     * 
     * @return
     *     The customerRatingImage
     */
    public String getCustomerRatingImage() {
        return customerRatingImage;
    }

    /**
     * 
     * @param customerRatingImage
     *     The customerRatingImage
     */
    public void setCustomerRatingImage(String customerRatingImage) {
        this.customerRatingImage = customerRatingImage;
    }

    /**
     * 
     * @return
     *     The categoryNode
     */
    public String getCategoryNode() {
        return categoryNode;
    }

    /**
     * 
     * @param categoryNode
     *     The categoryNode
     */
    public void setCategoryNode(String categoryNode) {
        this.categoryNode = categoryNode;
    }

    /**
     * 
     * @return
     *     The bundle
     */
    public Boolean getBundle() {
        return bundle;
    }

    /**
     * 
     * @param bundle
     *     The bundle
     */
    public void setBundle(Boolean bundle) {
        this.bundle = bundle;
    }

    /**
     * 
     * @return
     *     The stock
     */
    public String getStock() {
        return stock;
    }

    /**
     * 
     * @param stock
     *     The stock
     */
    public void setStock(String stock) {
        this.stock = stock;
    }

    /**
     * 
     * @return
     *     The addToCartUrl
     */
    public String getAddToCartUrl() {
        return addToCartUrl;
    }

    /**
     * 
     * @param addToCartUrl
     *     The addToCartUrl
     */
    public void setAddToCartUrl(String addToCartUrl) {
        this.addToCartUrl = addToCartUrl;
    }

    /**
     * 
     * @return
     *     The affiliateAddToCartUrl
     */
    public String getAffiliateAddToCartUrl() {
        return affiliateAddToCartUrl;
    }

    /**
     * 
     * @param affiliateAddToCartUrl
     *     The affiliateAddToCartUrl
     */
    public void setAffiliateAddToCartUrl(String affiliateAddToCartUrl) {
        this.affiliateAddToCartUrl = affiliateAddToCartUrl;
    }

    /**
     * 
     * @return
     *     The giftOptions
     */
    public GiftOptions getGiftOptions() {
        return giftOptions;
    }

    /**
     * 
     * @param giftOptions
     *     The giftOptions
     */
    public void setGiftOptions(GiftOptions giftOptions) {
        this.giftOptions = giftOptions;
    }

    /**
     * 
     * @return
     *     The imageEntities
     */
    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    /**
     * 
     * @param imageEntities
     *     The imageEntities
     */
    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    /**
     * 
     * @return
     *     The offerType
     */
    public String getOfferType() {
        return offerType;
    }

    /**
     * 
     * @param offerType
     *     The offerType
     */
    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    /**
     * 
     * @return
     *     The shippingPassEligible
     */
    public Boolean getShippingPassEligible() {
        return shippingPassEligible;
    }

    /**
     * 
     * @param shippingPassEligible
     *     The shippingPassEligible
     */
    public void setShippingPassEligible(Boolean shippingPassEligible) {
        this.shippingPassEligible = shippingPassEligible;
    }

    /**
     * 
     * @return
     *     The availableOnline
     */
    public Boolean getAvailableOnline() {
        return availableOnline;
    }

    /**
     * 
     * @param availableOnline
     *     The availableOnline
     */
    public void setAvailableOnline(Boolean availableOnline) {
        this.availableOnline = availableOnline;
    }

}
