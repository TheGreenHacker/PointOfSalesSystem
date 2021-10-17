
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
    "StoreID",
    "PosID",
    "CustomerType",
    "PaymentMethod",
    "DeliveryType",
    "City",
    "State",
    "PinCode",
    "InvoiceLineItems"
})
public class MaskedPOSInvoice {

    @JsonProperty("InvoiceNumber")
    private Integer invoiceNumber;
    @JsonProperty("CreatedTime")
    private Long createdTime;
    @JsonProperty("StoreID")
    private String storeID;
    @JsonProperty("PosID")
    private String posID;
    @JsonProperty("CustomerType")
    private String customerType;
    @JsonProperty("PaymentMethod")
    private String paymentMethod;
    @JsonProperty("DeliveryType")
    private String deliveryType;
    @JsonProperty("City")
    private String city;
    @JsonProperty("State")
    private String state;
    @JsonProperty("PinCode")
    private String pinCode;
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

    public MaskedPOSInvoice withInvoiceNumber(Integer invoiceNumber) {
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

    public MaskedPOSInvoice withCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    @JsonProperty("StoreID")
    public String getStoreID() {
        return storeID;
    }

    @JsonProperty("StoreID")
    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public MaskedPOSInvoice withStoreID(String storeID) {
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

    public MaskedPOSInvoice withPosID(String posID) {
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

    public MaskedPOSInvoice withCustomerType(String customerType) {
        this.customerType = customerType;
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

    public MaskedPOSInvoice withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
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

    public MaskedPOSInvoice withDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
        return this;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    public MaskedPOSInvoice withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    public MaskedPOSInvoice withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("PinCode")
    public String getPinCode() {
        return pinCode;
    }

    @JsonProperty("PinCode")
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public MaskedPOSInvoice withPinCode(String pinCode) {
        this.pinCode = pinCode;
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

    public MaskedPOSInvoice withInvoiceLineItems(List<LineItem> invoiceLineItems) {
        this.invoiceLineItems = invoiceLineItems;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("invoiceNumber", invoiceNumber).append("createdTime", createdTime).append("storeID", storeID).append("posID", posID).append("customerType", customerType).append("paymentMethod", paymentMethod).append("deliveryType", deliveryType).append("city", city).append("state", state).append("pinCode", pinCode).append("invoiceLineItems", invoiceLineItems).toString();
    }

}
