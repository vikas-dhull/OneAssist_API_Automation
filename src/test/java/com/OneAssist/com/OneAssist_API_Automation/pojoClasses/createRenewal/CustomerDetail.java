
package com.OneAssist.com.OneAssist_API_Automation.pojoClasses.createRenewal;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CustomerDetail implements Serializable
{

    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("relationship")
    @Expose
    private String relationship;
    @SerializedName("previousCustId")
    @Expose
    private String previousCustId;
    private final static long serialVersionUID = -6903831423362722443L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomerDetail() {
    }

    /**
     * 
     * @param firstName
     * @param lastName
     * @param mobileNumber
     * @param middleName
     * @param emailId
     * @param previousCustId
     * @param relationship
     */
    public CustomerDetail(String firstName, String middleName, String lastName, String emailId, String mobileNumber, String relationship, String previousCustId) {
        super();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.relationship = relationship;
        this.previousCustId = previousCustId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPreviousCustId() {
        return previousCustId;
    }

    public void setPreviousCustId(String previousCustId) {
        this.previousCustId = previousCustId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(middleName).append(lastName).append(emailId).append(mobileNumber).append(relationship).append(previousCustId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerDetail) == false) {
            return false;
        }
        CustomerDetail rhs = ((CustomerDetail) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(middleName, rhs.middleName).append(lastName, rhs.lastName).append(emailId, rhs.emailId).append(mobileNumber, rhs.mobileNumber).append(relationship, rhs.relationship).append(previousCustId, rhs.previousCustId).isEquals();
    }

}
