package com.pran.finance;

public class MonthWastes {

    private String itemName;
    private Boolean isExpense;
    private Integer quantity;
    private Integer suOfOne;

    public MonthWastes(String itemName, Boolean isExpense, Integer quantity, Integer suOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.suOfOne = suOfOne;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setIsExpense(Boolean isExpense) {
        this.isExpense = isExpense;
    }

    public Boolean getExpense() {
        return isExpense;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setSuOfOne(Integer suOfOne) {
        this.suOfOne = suOfOne;
    }

    public Integer getSuOfOne() {
        return suOfOne;
    }
}
