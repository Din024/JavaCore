package com.pran.finance;

public class YearWastes {

    private String month;
    private Integer amount;
    private Boolean isExpense;

    public YearWastes(String month, Integer amount, Boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setIsExpense(Boolean isExpense) {
        this.isExpense = isExpense;
    }

    public Boolean getExpense() {
        return isExpense;
    }
}
