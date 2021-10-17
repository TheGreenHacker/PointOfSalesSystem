
package com.jack.li.kafka.projects.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "InvoiceNumber",
    "CustomerCardNumber",
    "TotalAmount",
    "EarnedLoyaltyPoints"
})
public class Loyalty {

    @JsonProperty("InvoiceNumber")
    private Integer invoiceNumber;
    @JsonProperty("CustomerCardNumber")
    private String customerCardNumber;
    @JsonProperty("TotalAmount")
    private Double totalAmount;
    @JsonProperty("EarnedLoyaltyPoints")
    private Integer earnedLoyaltyPoints;

    @JsonProperty("InvoiceNumber")
    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("InvoiceNumber")
    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Loyalty withInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    @JsonProperty("CustomerCardNumber")
    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    @JsonProperty("CustomerCardNumber")
    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    public Loyalty withCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
        return this;
    }

    @JsonProperty("TotalAmount")
    public Double getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("TotalAmount")
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Loyalty withTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    @JsonProperty("EarnedLoyaltyPoints")
    public Integer getEarnedLoyaltyPoints() {
        return earnedLoyaltyPoints;
    }

    @JsonProperty("EarnedLoyaltyPoints")
    public void setEarnedLoyaltyPoints(Integer earnedLoyaltyPoints) {
        this.earnedLoyaltyPoints = earnedLoyaltyPoints;
    }

    public Loyalty withEarnedLoyaltyPoints(Integer earnedLoyaltyPoints) {
        this.earnedLoyaltyPoints = earnedLoyaltyPoints;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("invoiceNumber", invoiceNumber).append("customerCardNumber", customerCardNumber).append("totalAmount", totalAmount).append("earnedLoyaltyPoints", earnedLoyaltyPoints).toString();
    }

}
