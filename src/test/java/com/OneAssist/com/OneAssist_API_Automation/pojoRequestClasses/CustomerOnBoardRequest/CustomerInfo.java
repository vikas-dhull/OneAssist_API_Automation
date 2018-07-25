
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest;

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

    @SerializedName("salutation")
    @Expose
    private String salutation;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("customerTempId")
    @Expose
    private String customerTempId;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("mobileNumber")
    @Expose
    private Integer mobileNumber;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("relationship")
    @Expose
    private String relationship;
    @SerializedName("customerdob")
    @Expose
    private String customerdob;
    @SerializedName("panCard")
    @Expose
    private String panCard;
    @SerializedName("dlNo")
    @Expose
    private String dlNo;
    @SerializedName("passport")
    @Expose
    private String passport;
    @SerializedName("aadharId")
    @Expose
    private String aadharId;
    @SerializedName("previousCustomerId")
    @Expose
    private String previousCustomerId;
    @SerializedName("documentDownload")
    @Expose
    private String documentDownload;
    @SerializedName("assetInfo")
    @Expose
    private List<AssetInfo> assetInfo = new ArrayList<AssetInfo>();
    private final static long serialVersionUID = -7444861250775245561L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomerInfo() {
    }

    /**
     * 
     * @param lastName
     * @param panCard
     * @param gender
     * @param mobileNumber
     * @param dlNo
     * @param customerTempId
     * @param emailId
     * @param aadharId
     * @param documentDownload
     * @param firstName
     * @param passport
     * @param customerdob
     * @param middleName
     * @param salutation
     * @param relationship
     * @param previousCustomerId
     * @param assetInfo
     */
    public CustomerInfo(String salutation, String firstName, String middleName, String lastName, String customerTempId, String emailId, Integer mobileNumber, String gender, String relationship, String customerdob, String panCard, String dlNo, String passport, String aadharId, String previousCustomerId, String documentDownload, List<AssetInfo> assetInfo) {
        super();
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.customerTempId = customerTempId;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.relationship = relationship;
        this.customerdob = customerdob;
        this.panCard = panCard;
        this.dlNo = dlNo;
        this.passport = passport;
        this.aadharId = aadharId;
        this.previousCustomerId = previousCustomerId;
        this.documentDownload = documentDownload;
        this.assetInfo = assetInfo;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerTempId() {
        return customerTempId;
    }

    public void setCustomerTempId(String customerTempId) {
        this.customerTempId = customerTempId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getCustomerdob() {
        return customerdob;
    }

    public void setCustomerdob(String customerdob) {
        this.customerdob = customerdob;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getDlNo() {
        return dlNo;
    }

    public void setDlNo(String dlNo) {
        this.dlNo = dlNo;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAadharId() {
        return aadharId;
    }

    public void setAadharId(String aadharId) {
        this.aadharId = aadharId;
    }

    public String getPreviousCustomerId() {
        return previousCustomerId;
    }

    public void setPreviousCustomerId(String previousCustomerId) {
        this.previousCustomerId = previousCustomerId;
    }

    public String getDocumentDownload() {
        return documentDownload;
    }

    public void setDocumentDownload(String documentDownload) {
        this.documentDownload = documentDownload;
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
        return new HashCodeBuilder().append(salutation).append(firstName).append(middleName).append(lastName).append(customerTempId).append(emailId).append(mobileNumber).append(gender).append(relationship).append(customerdob).append(panCard).append(dlNo).append(passport).append(aadharId).append(previousCustomerId).append(documentDownload).append(assetInfo).toHashCode();
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
        return new EqualsBuilder().append(salutation, rhs.salutation).append(firstName, rhs.firstName).append(middleName, rhs.middleName).append(lastName, rhs.lastName).append(customerTempId, rhs.customerTempId).append(emailId, rhs.emailId).append(mobileNumber, rhs.mobileNumber).append(gender, rhs.gender).append(relationship, rhs.relationship).append(customerdob, rhs.customerdob).append(panCard, rhs.panCard).append(dlNo, rhs.dlNo).append(passport, rhs.passport).append(aadharId, rhs.aadharId).append(previousCustomerId, rhs.previousCustomerId).append(documentDownload, rhs.documentDownload).append(assetInfo, rhs.assetInfo).isEquals();
    }

}
