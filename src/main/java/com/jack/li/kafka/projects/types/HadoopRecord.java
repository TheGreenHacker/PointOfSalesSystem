
package com.jack.li.kafka.projects.types;

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
    "ItemCode",
    "Description",
    "Price",
    "Quantity",
    "TotalValue"
})
public class HadoopRecord {

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
    @JsonProperty("ItemCode")
    private String itemCode;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("TotalValue")
    private Double totalValue;

    @JsonProperty("InvoiceNumber")
    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("InvoiceNumber")
    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public HadoopRecord withInvoiceNumber(Integer invoiceNumber) {
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

    public HadoopRecord withCreatedTime(Long createdTime) {
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

    public HadoopRecord withStoreID(String storeID) {
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

    public HadoopRecord withPosID(String posID) {
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

    public HadoopRecord withCustomerType(String customerType) {
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

    public HadoopRecord withPaymentMethod(String paymentMethod) {
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

    public HadoopRecord withDeliveryType(String deliveryType) {
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

    public HadoopRecord withCity(String city) {
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

    public HadoopRecord withState(String state) {
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

    public HadoopRecord withPinCode(String pinCode) {
        this.pinCode = pinCode;
        return this;
    }

    @JsonProperty("ItemCode")
    public String getItemCode() {
        return itemCode;
    }

    @JsonProperty("ItemCode")
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public HadoopRecord withItemCode(String itemCode) {
        this.itemCode = itemCode;
        return this;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public HadoopRecord withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("Price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Double price) {
        this.price = price;
    }

    public HadoopRecord withPrice(Double price) {
        this.price = price;
        return this;
    }

    @JsonProperty("Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public HadoopRecord withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @JsonProperty("TotalValue")
    public Double getTotalValue() {
        return totalValue;
    }

    @JsonProperty("TotalValue")
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public HadoopRecord withTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("invoiceNumber", invoiceNumber).append("createdTime", createdTime).append("storeID", storeID).append("posID", posID).append("customerType", customerType).append("paymentMethod", paymentMethod).append("deliveryType", deliveryType).append("city", city).append("state", state).append("pinCode", pinCode).append("itemCode", itemCode).append("description", description).append("price", price).append("quantity", quantity).append("totalValue", totalValue).toString();
    }

}
