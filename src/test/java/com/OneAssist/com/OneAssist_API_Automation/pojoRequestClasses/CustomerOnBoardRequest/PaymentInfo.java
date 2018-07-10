
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PaymentInfo implements Serializable
{

    @SerializedName("mid")
    @Expose
    private String mid;
    @SerializedName("acquirer")
    @Expose
    private String acquirer;
    @SerializedName("accountNo")
    @Expose
    private String accountNo;
    @SerializedName("accountHolderName")
    @Expose
    private String accountHolderName;
    @SerializedName("accountType")
    @Expose
    private String accountType;
    @SerializedName("ifscCode")
    @Expose
    private String ifscCode;
    @SerializedName("issueOnBranch")
    @Expose
    private String issueOnBranch;
    @SerializedName("ecsStartDate")
    @Expose
    private String ecsStartDate;
    @SerializedName("ecsEndDate")
    @Expose
    private String ecsEndDate;
    @SerializedName("chequeNo")
    @Expose
    private String chequeNo;
    @SerializedName("micrNo")
    @Expose
    private String micrNo;
    @SerializedName("expiryMonth")
    @Expose
    private String expiryMonth;
    @SerializedName("expiryYear")
    @Expose
    private String expiryYear;
    @SerializedName("issuerBank")
    @Expose
    private String issuerBank;
    @SerializedName("paymentStatus")
    @Expose
    private String paymentStatus;
    @SerializedName("cardLevel")
    @Expose
    private String cardLevel;
    @SerializedName("paymentMode")
    @Expose
    private String paymentMode;
    private final static long serialVersionUID = 8316515430066254893L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaymentInfo() {
    }

    /**
     * 
     * @param paymentMode
     * @param chequeNo
     * @param cardLevel
     * @param accountType
     * @param ecsEndDate
     * @param expiryMonth
     * @param mid
     * @param issuerBank
     * @param expiryYear
     * @param acquirer
     * @param issueOnBranch
     * @param accountHolderName
     * @param accountNo
     * @param micrNo
     * @param ifscCode
     * @param ecsStartDate
     * @param paymentStatus
     */
    public PaymentInfo(String mid, String acquirer, String accountNo, String accountHolderName, String accountType, String ifscCode, String issueOnBranch, String ecsStartDate, String ecsEndDate, String chequeNo, String micrNo, String expiryMonth, String expiryYear, String issuerBank, String paymentStatus, String cardLevel, String paymentMode) {
        super();
        this.mid = mid;
        this.acquirer = acquirer;
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.ifscCode = ifscCode;
        this.issueOnBranch = issueOnBranch;
        this.ecsStartDate = ecsStartDate;
        this.ecsEndDate = ecsEndDate;
        this.chequeNo = chequeNo;
        this.micrNo = micrNo;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.issuerBank = issuerBank;
        this.paymentStatus = paymentStatus;
        this.cardLevel = cardLevel;
        this.paymentMode = paymentMode;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(String acquirer) {
        this.acquirer = acquirer;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getIssueOnBranch() {
        return issueOnBranch;
    }

    public void setIssueOnBranch(String issueOnBranch) {
        this.issueOnBranch = issueOnBranch;
    }

    public String getEcsStartDate() {
        return ecsStartDate;
    }

    public void setEcsStartDate(String ecsStartDate) {
        this.ecsStartDate = ecsStartDate;
    }

    public String getEcsEndDate() {
        return ecsEndDate;
    }

    public void setEcsEndDate(String ecsEndDate) {
        this.ecsEndDate = ecsEndDate;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getMicrNo() {
        return micrNo;
    }

    public void setMicrNo(String micrNo) {
        this.micrNo = micrNo;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getIssuerBank() {
        return issuerBank;
    }

    public void setIssuerBank(String issuerBank) {
        this.issuerBank = issuerBank;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(String cardLevel) {
        this.cardLevel = cardLevel;
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
        return new HashCodeBuilder().append(mid).append(acquirer).append(accountNo).append(accountHolderName).append(accountType).append(ifscCode).append(issueOnBranch).append(ecsStartDate).append(ecsEndDate).append(chequeNo).append(micrNo).append(expiryMonth).append(expiryYear).append(issuerBank).append(paymentStatus).append(cardLevel).append(paymentMode).toHashCode();
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
        return new EqualsBuilder().append(mid, rhs.mid).append(acquirer, rhs.acquirer).append(accountNo, rhs.accountNo).append(accountHolderName, rhs.accountHolderName).append(accountType, rhs.accountType).append(ifscCode, rhs.ifscCode).append(issueOnBranch, rhs.issueOnBranch).append(ecsStartDate, rhs.ecsStartDate).append(ecsEndDate, rhs.ecsEndDate).append(chequeNo, rhs.chequeNo).append(micrNo, rhs.micrNo).append(expiryMonth, rhs.expiryMonth).append(expiryYear, rhs.expiryYear).append(issuerBank, rhs.issuerBank).append(paymentStatus, rhs.paymentStatus).append(cardLevel, rhs.cardLevel).append(paymentMode, rhs.paymentMode).isEquals();
    }

}
