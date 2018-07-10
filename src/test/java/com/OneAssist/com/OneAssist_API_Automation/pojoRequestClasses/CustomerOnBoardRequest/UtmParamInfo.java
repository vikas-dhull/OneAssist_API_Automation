
package com.OneAssist.com.OneAssist_API_Automation.pojoRequestClasses.CustomerOnBoardRequest;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UtmParamInfo implements Serializable
{

    @SerializedName("utmSource")
    @Expose
    private String utmSource;
    @SerializedName("adGroup")
    @Expose
    private String adGroup;
    @SerializedName("crmAgent")
    @Expose
    private String crmAgent;
    @SerializedName("leadSource")
    @Expose
    private String leadSource;
    @SerializedName("leadCreatedDate")
    @Expose
    private String leadCreatedDate;
    @SerializedName("utmCampaign")
    @Expose
    private String utmCampaign;
    @SerializedName("utmContent")
    @Expose
    private String utmContent;
    @SerializedName("utmTerm")
    @Expose
    private String utmTerm;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("utmMedium")
    @Expose
    private String utmMedium;
    private final static long serialVersionUID = -8341668450935969302L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UtmParamInfo() {
    }

    /**
     * 
     * @param leadCreatedDate
     * @param utmSource
     * @param adGroup
     * @param leadSource
     * @param crmAgent
     * @param utmTerm
     * @param utmContent
     * @param utmMedium
     * @param utmCampaign
     * @param url
     */
    public UtmParamInfo(String utmSource, String adGroup, String crmAgent, String leadSource, String leadCreatedDate, String utmCampaign, String utmContent, String utmTerm, String url, String utmMedium) {
        super();
        this.utmSource = utmSource;
        this.adGroup = adGroup;
        this.crmAgent = crmAgent;
        this.leadSource = leadSource;
        this.leadCreatedDate = leadCreatedDate;
        this.utmCampaign = utmCampaign;
        this.utmContent = utmContent;
        this.utmTerm = utmTerm;
        this.url = url;
        this.utmMedium = utmMedium;
    }

    public String getUtmSource() {
        return utmSource;
    }

    public void setUtmSource(String utmSource) {
        this.utmSource = utmSource;
    }

    public String getAdGroup() {
        return adGroup;
    }

    public void setAdGroup(String adGroup) {
        this.adGroup = adGroup;
    }

    public String getCrmAgent() {
        return crmAgent;
    }

    public void setCrmAgent(String crmAgent) {
        this.crmAgent = crmAgent;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getLeadCreatedDate() {
        return leadCreatedDate;
    }

    public void setLeadCreatedDate(String leadCreatedDate) {
        this.leadCreatedDate = leadCreatedDate;
    }

    public String getUtmCampaign() {
        return utmCampaign;
    }

    public void setUtmCampaign(String utmCampaign) {
        this.utmCampaign = utmCampaign;
    }

    public String getUtmContent() {
        return utmContent;
    }

    public void setUtmContent(String utmContent) {
        this.utmContent = utmContent;
    }

    public String getUtmTerm() {
        return utmTerm;
    }

    public void setUtmTerm(String utmTerm) {
        this.utmTerm = utmTerm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUtmMedium() {
        return utmMedium;
    }

    public void setUtmMedium(String utmMedium) {
        this.utmMedium = utmMedium;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(utmSource).append(adGroup).append(crmAgent).append(leadSource).append(leadCreatedDate).append(utmCampaign).append(utmContent).append(utmTerm).append(url).append(utmMedium).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UtmParamInfo) == false) {
            return false;
        }
        UtmParamInfo rhs = ((UtmParamInfo) other);
        return new EqualsBuilder().append(utmSource, rhs.utmSource).append(adGroup, rhs.adGroup).append(crmAgent, rhs.crmAgent).append(leadSource, rhs.leadSource).append(leadCreatedDate, rhs.leadCreatedDate).append(utmCampaign, rhs.utmCampaign).append(utmContent, rhs.utmContent).append(utmTerm, rhs.utmTerm).append(url, rhs.url).append(utmMedium, rhs.utmMedium).isEquals();
    }

}
