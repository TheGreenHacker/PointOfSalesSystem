
package com.jack.li.kafka.projects.types;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "StoreID",
    "PosID",
    "CustomerType",
    "DeliveryType",
    "DeliveryAddress"
})
public class POSInvoice
    extends Invoice
{

    @JsonProperty("StoreID")
    private String storeID;
    @JsonProperty("PosID")
    private String posID;
    @JsonProperty("CustomerType")
    private String customerType;
    @JsonProperty("DeliveryType")
    private String deliveryType;
    @JsonProperty("DeliveryAddress")
    private DeliveryAddress deliveryAddress;

    @JsonProperty("StoreID")
    public String getStoreID() {
        return storeID;
    }

    @JsonProperty("StoreID")
    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public POSInvoice withStoreID(String storeID) {
        this.storeID = storeID;
        return this;
    }

    @JsonProperty("PosID")
    public String getPosID() {
        return posID;
    }

    @JsonProperty("PosID")
    public void setPosID(String posID) {
        this.posID = posID;
    }

    public POSInvoice withPosID(String posID) {
        this.posID = posID;
        return this;
    }

    @JsonProperty("CustomerType")
    public String getCustomerType() {
        return customerType;
    }

    @JsonProperty("CustomerType")
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public POSInvoice withCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    @JsonProperty("DeliveryType")
    public String getDeliveryType() {
        return deliveryType;
    }

    @JsonProperty("DeliveryType")
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public POSInvoice withDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
        return this;
    }

    @JsonProperty("DeliveryAddress")
    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    @JsonProperty("DeliveryAddress")
    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public POSInvoice withDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
        return this;
    }

    @Override
    public POSInvoice withInvoiceNumber(Integer invoiceNumber) {
        super.withInvoiceNumber(invoiceNumber);
        return this;
    }

    @Override
    public POSInvoice withCreatedTime(Long createdTime) {
        super.withCreatedTime(createdTime);
        return this;
    }

    @Override
    public POSInvoice withCustomerCardNumber(String customerCardNumber) {
        super.withCustomerCardNumber(customerCardNumber);
        return this;
    }

    @Override
    public POSInvoice withTotalAmount(Double totalAmount) {
        super.withTotalAmount(totalAmount);
        return this;
    }

    @Override
    public POSInvoice withNumberOfItems(Integer numberOfItems) {
        super.withNumberOfItems(numberOfItems);
        return this;
    }

    @Override
    public POSInvoice withPaymentMethod(String paymentMethod) {
        super.withPaymentMethod(paymentMethod);
        return this;
    }

    @Override
    public POSInvoice withTaxableAmount(Double taxableAmount) {
        super.withTaxableAmount(taxableAmount);
        return this;
    }

    @Override
    public POSInvoice withCGST(Double cGST) {
        super.withCGST(cGST);
        return this;
    }

    @Override
    public POSInvoice withSGCT(Double sGCT) {
        super.withSGCT(sGCT);
        return this;
    }

    @Override
    public POSInvoice withCESS(Double cESS) {
        super.withCESS(cESS);
        return this;
    }

    @Override
    public POSInvoice withInvoiceLineItems(List<LineItem> invoiceLineItems) {
        super.withInvoiceLineItems(invoiceLineItems);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).appendSuper(super.toString()).append("storeID", storeID).append("posID", posID).append("customerType", customerType).append("deliveryType", deliveryType).append("deliveryAddress", deliveryAddress).toString();
    }

}
