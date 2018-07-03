
package com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.createRenewalResponse;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductInfo implements Serializable
{

    @SerializedName("productCode")
    @Expose
    private String productCode;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("categoryCode")
    @Expose
    private String categoryCode;
    private final static long serialVersionUID = 3398727318556383773L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductInfo() {
    }

    /**
     * 
     * @param productCode
     * @param categoryCode
     * @param productName
     */
    public ProductInfo(String productCode, String productName, String categoryCode) {
        super();
        this.productCode = productCode;
        this.productName = productName;
        this.categoryCode = categoryCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productCode).append(productName).append(categoryCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductInfo) == false) {
            return false;
        }
        ProductInfo rhs = ((ProductInfo) other);
        return new EqualsBuilder().append(productCode, rhs.productCode).append(productName, rhs.productName).append(categoryCode, rhs.categoryCode).isEquals();
    }

}
