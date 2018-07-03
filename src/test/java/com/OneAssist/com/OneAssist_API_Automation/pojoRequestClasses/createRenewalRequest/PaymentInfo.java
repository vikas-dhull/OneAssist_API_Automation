
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.createRenewalRequest;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PaymentInfo implements Serializable
{

    @SerializedName("paymentMode")
    @Expose
    private String paymentMode;
    private final static long serialVersionUID = 3207097030222938934L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaymentInfo() {
    }

    /**
     * 
     * @param paymentMode
     */
    public PaymentInfo(String paymentMode) {
        super();
        this.paymentMode = paymentMode;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(paymentMode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentInfo) == false) {
            return false;
        }
        PaymentInfo rhs = ((PaymentInfo) other);
        return new EqualsBuilder().append(paymentMode, rhs.paymentMode).isEquals();
    }

}
