
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AddressInfo implements Serializable
{

    @SerializedName("addrType")
    @Expose
    private String addrType;
    @SerializedName("addrLine1")
    @Expose
    private String addrLine1;
    @SerializedName("addrLine2")
    @Expose
    private String addrLine2;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("pinCode")
    @Expose
    private String pinCode;
    @SerializedName("cityCode")
    @Expose
    private String cityCode;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("telNo")
    @Expose
    private String telNo;
    @SerializedName("stdCode")
    @Expose
    private String stdCode;
    @SerializedName("isMailingAddress")
    @Expose
    private String isMailingAddress;
    private final static long serialVersionUID = 3170569146904808924L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AddressInfo() {
    }

    /**
     * 
     * @param stdCode
     * @param addrLine2
     * @param cityCode
     * @param addrLine1
     * @param pinCode
     * @param stateCode
     * @param isMailingAddress
     * @param landmark
     * @param telNo
     * @param addrType
     */
    public AddressInfo(String addrType, String addrLine1, String addrLine2, String landmark, String pinCode, String cityCode, String stateCode, String telNo, String stdCode, String isMailingAddress) {
        super();
        this.addrType = addrType;
        this.addrLine1 = addrLine1;
        this.addrLine2 = addrLine2;
        this.landmark = landmark;
        this.pinCode = pinCode;
        this.cityCode = cityCode;
        this.stateCode = stateCode;
        this.telNo = telNo;
        this.stdCode = stdCode;
        this.isMailingAddress = isMailingAddress;
    }

    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getStdCode() {
        return stdCode;
    }

    public void setStdCode(String stdCode) {
        this.stdCode = stdCode;
    }

    public String getIsMailingAddress() {
        return isMailingAddress;
    }

    public void setIsMailingAddress(String isMailingAddress) {
        this.isMailingAddress = isMailingAddress;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(addrType).append(addrLine1).append(addrLine2).append(landmark).append(pinCode).append(cityCode).append(stateCode).append(telNo).append(stdCode).append(isMailingAddress).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddressInfo) == false) {
            return false;
        }
        AddressInfo rhs = ((AddressInfo) other);
        return new EqualsBuilder().append(addrType, rhs.addrType).append(addrLine1, rhs.addrLine1).append(addrLine2, rhs.addrLine2).append(landmark, rhs.landmark).append(pinCode, rhs.pinCode).append(cityCode, rhs.cityCode).append(stateCode, rhs.stateCode).append(telNo, rhs.telNo).append(stdCode, rhs.stdCode).append(isMailingAddress, rhs.isMailingAddress).isEquals();
    }

}
