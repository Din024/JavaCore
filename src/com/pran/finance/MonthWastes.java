package com.pran.finance;

import java.util.ArrayList;

public class MonthWastes {

    private ArrayList<String> itemName = new ArrayList<>();
    private ArrayList<Boolean> isExpense = new ArrayList<>();
    private ArrayList<Integer> quantity = new ArrayList<>();
    private ArrayList<Integer> sumOfOne = new ArrayList<>();

    public MonthWastes(){}

    public MonthWastes(ArrayList<String> itemName, ArrayList<Boolean> isExpense, ArrayList<Integer> quantity, ArrayList<Integer> sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    public void setItemName(String itemName) { this.itemName.add(itemName); }

    public ArrayList<String> getItemName() {
        return itemName;
    }

    public void setIsExpense(Boolean isExpense) {
        this.isExpense.add(isExpense);
    }

    public ArrayList<Boolean> getIsExpense() {
        return isExpense;
    }

    public void setQuantity(Integer quantity) {
        this.quantity.add(quantity);
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setSumOfOne(Integer sumOfOne) {
        this.sumOfOne.add(sumOfOne);
    }

    public ArrayList<Integer> getSumOfOne() {
        return sumOfOne;
    }

    public static ArrayList<Integer> sumOfWastes(ArrayList<MonthWastes> monthWastes) {
        ArrayList<Integer> sumOfWastes = new ArrayList<>();
        int tempSum = 0;
        for (MonthWastes wastes : monthWastes) {
            for (int i = 0; i < wastes.getIsExpense().size(); i++) {
                if (wastes.getIsExpense().get(i)) {
                    tempSum += wastes.getSumOfOne().get(i) * wastes.getQuantity().get(i);
                }
            }
            sumOfWastes.add(tempSum);
            tempSum = 0;
        }
        return sumOfWastes;
    }

    public static ArrayList<Integer> sumOfIncome(ArrayList<MonthWastes> monthWastes) {
        ArrayList<Integer> sumOfIncome = new ArrayList<>();
        int tempSum = 0;
        for (MonthWastes wastes : monthWastes) {
            for (int i = 0; i < wastes.getIsExpense().size(); i++) {
                if (!wastes.getIsExpense().get(i)) {
                    tempSum += wastes.getSumOfOne().get(i) * wastes.getQuantity().get(i);
                }
            }
            sumOfIncome.add(tempSum);
            tempSum = 0;
        }
        return sumOfIncome;
    }

    public static void monthInfo(ArrayList<MonthWastes> monthWastes) {
        int maxIncome = 0, maxWaste = 0;
        int numIncome = 0, numWaste = 0;
        for (int i = 0; i < monthWastes.size(); i++) {
            for (int j = 0; j < monthWastes.get(i).getIsExpense().size(); j++) {
                if ((monthWastes.get(i).getIsExpense().get(j)) && (monthWastes.get(i).getQuantity().get(j) * monthWastes.get(i).getSumOfOne().get(j) > maxWaste)) {
                    maxWaste = monthWastes.get(i).getQuantity().get(j) * monthWastes.get(i).getSumOfOne().get(j);
                    numWaste = j;
                }
                if ((!monthWastes.get(i).getIsExpense().get(j)) && (monthWastes.get(i).getQuantity().get(j) * monthWastes.get(i).getSumOfOne().get(j) > maxIncome)) {
                    maxIncome = monthWastes.get(i).getQuantity().get(j) * monthWastes.get(i).getSumOfOne().get(j);
                    numIncome = j;
                }
            }
            System.out.println("В " + (i + 1) + " месяце наибольшая трата = " + maxWaste + " у товара " + monthWastes.get(i).getItemName().get(numWaste));
            System.out.println("А наибольшая прибыль = " + maxIncome + " у товара " + monthWastes.get(i).getItemName().get(numIncome));
        }
    }
}
