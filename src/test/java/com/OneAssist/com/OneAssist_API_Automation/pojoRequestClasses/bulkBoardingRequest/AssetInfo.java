
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AssetInfo implements Serializable
{

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
    private final static long serialVersionUID = 2742742084438425883L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AssetInfo() {
    }

    /**
     * 
     * @param productCode
     * @param assetModel
     * @param invoiceValue
     * @param assetMake
     * @param invoiceDate
     * @param serialNo1
     */
    public AssetInfo(String productCode, String assetMake, String assetModel, String invoiceDate, Integer invoiceValue, String serialNo1) {
        super();
        this.productCode = productCode;
        this.assetMake = assetMake;
        this.assetModel = assetModel;
        this.invoiceDate = invoiceDate;
        this.invoiceValue = invoiceValue;
        this.serialNo1 = serialNo1;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productCode).append(assetMake).append(assetModel).append(invoiceDate).append(invoiceValue).append(serialNo1).toHashCode();
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
        return new EqualsBuilder().append(productCode, rhs.productCode).append(assetMake, rhs.assetMake).append(assetModel, rhs.assetModel).append(invoiceDate, rhs.invoiceDate).append(invoiceValue, rhs.invoiceValue).append(serialNo1, rhs.serialNo1).isEquals();
    }

}
