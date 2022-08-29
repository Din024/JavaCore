package com.pran.finance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class YearWastes {

    private ArrayList<String> month = new ArrayList<>();
    private ArrayList<Integer> amount = new ArrayList<>();
    private ArrayList<Boolean> isExpense = new ArrayList<>();

    public YearWastes(){}

    public YearWastes(ArrayList<String> month, ArrayList<Integer> amount, ArrayList<Boolean> isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public void setMonth(String month) {
        this.month.add(month);
    }

    public ArrayList<Integer> getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount.add(amount);
    }

    public ArrayList<String> getMonth() {
        return month;
    }

    public void setIsExpense(Boolean isExpense) {
        this.isExpense.add(isExpense);
    }

    public ArrayList<Boolean> getExpense() {
        return isExpense;
    }

    public static ArrayList<Integer> sumOfWastes (YearWastes yearWastes) {
        int tempMonth = 1;
        for (int i = 0; i < yearWastes.month.size() - 1; i++) {
            if (!yearWastes.month.get(i).equals(yearWastes.month.get(i + 1)))
                tempMonth++;
        }
        ArrayList<Integer> sumOfWastes = new ArrayList<>();
        Integer[] tempSumOfWastes = new Integer[tempMonth];
        Arrays.fill(tempSumOfWastes, 0);
        for(int i = 0; i < yearWastes.getExpense().size(); i++) {
            if(yearWastes.getExpense().get(i)) {
                tempSumOfWastes[Integer.parseInt(yearWastes.getMonth().get(i)) - 1] += yearWastes.getAmount().get(i);
            }
        }
        Collections.addAll(sumOfWastes, tempSumOfWastes);
        return sumOfWastes;
    }

    public static ArrayList<Integer> sumOfIncome (YearWastes yearWastes) {
        int tempMonth = 1;
        for (int i = 0; i < yearWastes.month.size() - 1; i++) {
            if (!yearWastes.month.get(i).equals(yearWastes.month.get(i + 1)))
                tempMonth++;
        }
        ArrayList<Integer> sumOfIncome = new ArrayList<>();
        Integer[] tempSumOfIncome = new Integer[tempMonth];
        Arrays.fill(tempSumOfIncome, 0);
        for(int i = 0; i < yearWastes.getExpense().size(); i++) {
            if(!yearWastes.getExpense().get(i)) {
                tempSumOfIncome[Integer.parseInt(yearWastes.getMonth().get(i)) - 1] += yearWastes.getAmount().get(i);
            }
        }
        Collections.addAll(sumOfIncome, tempSumOfIncome);
        return sumOfIncome;
    }

    public static void yearInfo(YearWastes yearWastes) {
        ArrayList<Integer> wastes = sumOfWastes(yearWastes);
        ArrayList<Integer> income = sumOfIncome(yearWastes);
        double averageWaste = 0.0, averageIncome = 0.0;
        for (int i = 0; i < wastes.size(); i++) {
            averageWaste += wastes.get(i);
            averageIncome += income.get(i);
            System.out.println("В " + (i + 1) + " месяце выручка = " + (income.get(i) - wastes.get(i)));
        }
        System.out.println("Средний расход = " + averageWaste/wastes.size());
        System.out.println("Средний доход = " + averageIncome/income.size());
    }
}
