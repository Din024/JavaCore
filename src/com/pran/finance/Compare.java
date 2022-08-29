package com.pran.finance;

import java.util.ArrayList;
import java.util.Objects;

public class Compare {
    public static void compare(ArrayList<Integer> monthWastes, ArrayList<Integer> yearWastes, ArrayList<Integer> monthIncome, ArrayList<Integer> yearIncome){
        for (int i = 0; i < monthWastes.size(); i++) {
            if ((!Objects.equals(monthWastes.get(i), yearWastes.get(i))) && (!Objects.equals(monthIncome.get(i), yearIncome.get(i))) ) {
                System.out.println("В 0" + (i+1) + " месяце данные не совпадают с годовым отчетом");
            } else {
                System.out.println("В 0" + (i+1) + " все хорошо");
            }
        }
    }
}
