
package com.OneAssist.com.OneAssist_API_Automation.pojoResponseClasses.createRenewalResponse;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PendingCustomerInfo implements Serializable
{

    @SerializedName("customerTempId")
    @Expose
    private Integer customerTempId;
    @SerializedName("previousCustomerId")
    @Expose
    private Integer previousCustomerId;
    @SerializedName("activityReferenceId")
    @Expose
    private String activityReferenceId;
    private final static long serialVersionUID = 3511399805083468969L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PendingCustomerInfo() {
    }

    /**
     * 
     * @param customerTempId
     * @param previousCustomerId
     * @param activityReferenceId
     */
    public PendingCustomerInfo(Integer customerTempId, Integer previousCustomerId, String activityReferenceId) {
        super();
        this.customerTempId = customerTempId;
        this.previousCustomerId = previousCustomerId;
        this.activityReferenceId = activityReferenceId;
    }

    public Integer getCustomerTempId() {
        return customerTempId;
    }

    public void setCustomerTempId(Integer customerTempId) {
        this.customerTempId = customerTempId;
    }

    public Integer getPreviousCustomerId() {
        return previousCustomerId;
    }

    public void setPreviousCustomerId(Integer previousCustomerId) {
        this.previousCustomerId = previousCustomerId;
    }

    public String getActivityReferenceId() {
        return activityReferenceId;
    }

    public void setActivityReferenceId(String activityReferenceId) {
        this.activityReferenceId = activityReferenceId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerTempId).append(previousCustomerId).append(activityReferenceId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PendingCustomerInfo) == false) {
            return false;
        }
        PendingCustomerInfo rhs = ((PendingCustomerInfo) other);
        return new EqualsBuilder().append(customerTempId, rhs.customerTempId).append(previousCustomerId, rhs.previousCustomerId).append(activityReferenceId, rhs.activityReferenceId).isEquals();
    }

}
