
package com.jack.li.kafka.projects.types;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "InvoiceNumber",
    "CreatedTime",
    "CustomerCardNumber",
    "TotalAmount",
    "NumberOfItems",
    "PaymentMethod",
    "TaxableAmount",
    "CGST",
    "SGCT",
    "CESS",
    "InvoiceLineItems"
})
public class Invoice {

    @JsonProperty("InvoiceNumber")
    private Integer invoiceNumber;
    @JsonProperty("CreatedTime")
    private Long createdTime;
    @JsonProperty("CustomerCardNumber")
    private String customerCardNumber;
    @JsonProperty("TotalAmount")
    private Double totalAmount;
    @JsonProperty("NumberOfItems")
    private Integer numberOfItems;
    @JsonProperty("PaymentMethod")
    private String paymentMethod;
    @JsonProperty("TaxableAmount")
    private Double taxableAmount;
    @JsonProperty("CGST")
    private Double cGST;
    @JsonProperty("SGCT")
    private Double sGCT;
    @JsonProperty("CESS")
    private Double cESS;
    @JsonProperty("InvoiceLineItems")
    private List<LineItem> invoiceLineItems = new ArrayList<LineItem>();

    @JsonProperty("InvoiceNumber")
    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("InvoiceNumber")
    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Invoice withInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }

    @JsonProperty("CreatedTime")
    public Long getCreatedTime() {
        return createdTime;
    }

    @JsonProperty("CreatedTime")
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Invoice withCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
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

    public Invoice withCustomerCardNumber(String customerCardNumber) {
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

    public Invoice withTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    @JsonProperty("NumberOfItems")
    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    @JsonProperty("NumberOfItems")
    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Invoice withNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
        return this;
    }

    @JsonProperty("PaymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("PaymentMethod")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Invoice withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    @JsonProperty("TaxableAmount")
    public Double getTaxableAmount() {
        return taxableAmount;
    }

    @JsonProperty("TaxableAmount")
    public void setTaxableAmount(Double taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public Invoice withTaxableAmount(Double taxableAmount) {
        this.taxableAmount = taxableAmount;
        return this;
    }

    @JsonProperty("CGST")
    public Double getCGST() {
        return cGST;
    }

    @JsonProperty("CGST")
    public void setCGST(Double cGST) {
        this.cGST = cGST;
    }

    public Invoice withCGST(Double cGST) {
        this.cGST = cGST;
        return this;
    }

    @JsonProperty("SGCT")
    public Double getSGCT() {
        return sGCT;
    }

    @JsonProperty("SGCT")
    public void setSGCT(Double sGCT) {
        this.sGCT = sGCT;
    }

    public Invoice withSGCT(Double sGCT) {
        this.sGCT = sGCT;
        return this;
    }

    @JsonProperty("CESS")
    public Double getCESS() {
        return cESS;
    }

    @JsonProperty("CESS")
    public void setCESS(Double cESS) {
        this.cESS = cESS;
    }

    public Invoice withCESS(Double cESS) {
        this.cESS = cESS;
        return this;
    }

    @JsonProperty("InvoiceLineItems")
    public List<LineItem> getInvoiceLineItems() {
        return invoiceLineItems;
    }

    @JsonProperty("InvoiceLineItems")
    public void setInvoiceLineItems(List<LineItem> invoiceLineItems) {
        this.invoiceLineItems = invoiceLineItems;
    }

    public Invoice withInvoiceLineItems(List<LineItem> invoiceLineItems) {
        this.invoiceLineItems = invoiceLineItems;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("invoiceNumber", invoiceNumber).append("createdTime", createdTime).append("customerCardNumber", customerCardNumber).append("totalAmount", totalAmount).append("numberOfItems", numberOfItems).append("paymentMethod", paymentMethod).append("taxableAmount", taxableAmount).append("cGST", cGST).append("sGCT", sGCT).append("cESS", cESS).append("invoiceLineItems", invoiceLineItems).toString();
    }

}
