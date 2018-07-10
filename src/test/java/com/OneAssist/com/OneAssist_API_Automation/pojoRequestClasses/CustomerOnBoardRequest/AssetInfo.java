
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AssetInfo implements Serializable
{

    @SerializedName("customerRelationType")
    @Expose
    private String customerRelationType;
    @SerializedName("productCode")
    @Expose
    private String productCode;
    @SerializedName("assetMake")
    @Expose
    private String assetMake;
    @SerializedName("assetModel")
    @Expose
    private String assetModel;
    @SerializedName("invoiceDate")
    @Expose
    private String invoiceDate;
    @SerializedName("invoiceValue")
    @Expose
    private Integer invoiceValue;
    @SerializedName("serialNo1")
    @Expose
    private String serialNo1;
    @SerializedName("serialNo2")
    @Expose
    private String serialNo2;
    @SerializedName("warrantyPeriod")
    @Expose
    private Integer warrantyPeriod;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("categoryCode")
    @Expose
    private String categoryCode;
    @SerializedName("technology")
    @Expose
    private String technology;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("sizeUnit")
    @Expose
    private String sizeUnit;
    private final static long serialVersionUID = -6185473102236654904L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AssetInfo() {
    }

    /**
     * 
     * @param customerRelationType
     * @param assetModel
     * @param invoiceValue
     * @param categoryCode
     * @param technology
     * @param invoiceDate
     * @param serialNo1
     * @param serialNo2
     * @param productName
     * @param warrantyPeriod
     * @param productCode
     * @param size
     * @param sizeUnit
     * @param assetMake
     * @param age
     */
    public AssetInfo(String customerRelationType, String productCode, String assetMake, String assetModel, String invoiceDate, Integer invoiceValue, String serialNo1, String serialNo2, Integer warrantyPeriod, String productName, String categoryCode, String technology, String age, String size, String sizeUnit) {
        super();
        this.customerRelationType = customerRelationType;
        this.productCode = productCode;
        this.assetMake = assetMake;
        this.assetModel = assetModel;
        this.invoiceDate = invoiceDate;
        this.invoiceValue = invoiceValue;
        this.serialNo1 = serialNo1;
        this.serialNo2 = serialNo2;
        this.warrantyPeriod = warrantyPeriod;
        this.productName = productName;
        this.categoryCode = categoryCode;
        this.technology = technology;
        this.age = age;
        this.size = size;
        this.sizeUnit = sizeUnit;
    }

    public String getCustomerRelationType() {
        return customerRelationType;
    }

    public void setCustomerRelationType(String customerRelationType) {
        this.customerRelationType = customerRelationType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getAssetMake() {
        return assetMake;
    }

    public void setAssetMake(String assetMake) {
        this.assetMake = assetMake;
    }

    public String getAssetModel() {
        return assetModel;
    }

    public void setAssetModel(String assetModel) {
        this.assetModel = assetModel;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Integer getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(Integer invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public String getSerialNo1() {
        return serialNo1;
    }

    public void setSerialNo1(String serialNo1) {
        this.serialNo1 = serialNo1;
    }

    public String getSerialNo2() {
        return serialNo2;
    }

    public void setSerialNo2(String serialNo2) {
        this.serialNo2 = serialNo2;
    }

    public Integer getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Integer warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerRelationType).append(productCode).append(assetMake).append(assetModel).append(invoiceDate).append(invoiceValue).append(serialNo1).append(serialNo2).append(warrantyPeriod).append(productName).append(categoryCode).append(technology).append(age).append(size).append(sizeUnit).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AssetInfo) == false) {
            return false;
        }
        AssetInfo rhs = ((AssetInfo) other);
        return new EqualsBuilder().append(customerRelationType, rhs.customerRelationType).append(productCode, rhs.productCode).append(assetMake, rhs.assetMake).append(assetModel, rhs.assetModel).append(invoiceDate, rhs.invoiceDate).append(invoiceValue, rhs.invoiceValue).append(serialNo1, rhs.serialNo1).append(serialNo2, rhs.serialNo2).append(warrantyPeriod, rhs.warrantyPeriod).append(productName, rhs.productName).append(categoryCode, rhs.categoryCode).append(technology, rhs.technology).append(age, rhs.age).append(size, rhs.size).append(sizeUnit, rhs.sizeUnit).isEquals();
    }

}
