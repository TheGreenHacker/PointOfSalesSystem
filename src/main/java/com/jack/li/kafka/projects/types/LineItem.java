
package com.jack.li.kafka.projects.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ItemCode",
    "Description",
    "Price",
    "Quantity",
    "TotalValue"
})
public class LineItem {

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

    @JsonProperty("ItemCode")
    public String getItemCode() {
        return itemCode;
    }

    @JsonProperty("ItemCode")
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public LineItem withItemCode(String itemCode) {
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

    public LineItem withDescription(String description) {
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

    public LineItem withPrice(Double price) {
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

    public LineItem withQuantity(Integer quantity) {
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

    public LineItem withTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("itemCode", itemCode).append("description", description).append("price", price).append("quantity", quantity).append("totalValue", totalValue).toString();
    }

}
