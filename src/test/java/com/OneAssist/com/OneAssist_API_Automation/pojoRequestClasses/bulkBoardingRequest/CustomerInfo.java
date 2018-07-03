
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.bulkBoardingRequest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CustomerInfo implements Serializable
{

    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("mobileNumber")
    @Expose
    private Long mobileNumber;
    @SerializedName("relationship")
    @Expose
    private String relationship;
    @SerializedName("assetInfo")
    @Expose
    private List<AssetInfo> assetInfo = new ArrayList<AssetInfo>();
    private final static long serialVersionUID = -2033182293203360346L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomerInfo() {
    }

    /**
     * 
     * @param firstName
     * @param mobileNumber
     * @param relationship
     * @param assetInfo
     */
    public CustomerInfo(String firstName, Long mobileNumber, String relationship, List<AssetInfo> assetInfo) {
        super();
        this.firstName = firstName;
        this.mobileNumber = mobileNumber;
        this.relationship = relationship;
        this.assetInfo = assetInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public List<AssetInfo> getAssetInfo() {
        return assetInfo;
    }

    public void setAssetInfo(List<AssetInfo> assetInfo) {
        this.assetInfo = assetInfo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(mobileNumber).append(relationship).append(assetInfo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerInfo) == false) {
            return false;
        }
        CustomerInfo rhs = ((CustomerInfo) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(mobileNumber, rhs.mobileNumber).append(relationship, rhs.relationship).append(assetInfo, rhs.assetInfo).isEquals();
    }

}
