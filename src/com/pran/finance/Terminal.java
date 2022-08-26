package com.pran.finance;

import java.util.ArrayList;
import java.util.Scanner;

public class Terminal {
    public static void menu() {
        ArrayList<MonthWastes> monthWastes = new ArrayList<>();
        YearWastes yearWastes = new YearWastes();
        Scanner scanner = new Scanner(System.in);
        String userInput = "default";
        String path;
        while (!userInput.equals("exit")) {
            System.out.print("""
                    Выберите цифру:
                    1) Считать все месячные отчеты
                    2) Считать годовой отчет
                    3) Сверить отчеты
                    4) Вывести информацию о всех месячных отчетах
                    5) Вывести информацию о годовом отчете
                    Для выхода используйте exit
                    """);
            userInput = scanner.nextLine();
            switch (userInput) {
                case ("1"):
                    System.out.println("Введите папку с отчетами: ");
                    path = scanner.nextLine();
                    FileReader.monthlyReport(path, monthWastes);
                    break;
                case ("2"):
                    System.out.println("Введите папку с отчетом: ");
                    path = scanner.nextLine();
                    FileReader.yearlyReport(path, yearWastes);
                    break;
                case ("3"):
                    System.out.println(MonthWastes.sumOfWastes(monthWastes));
                    System.out.println(MonthWastes.sumOfIncome(monthWastes));
                    System.out.println(YearWastes.sumOfWastes(yearWastes));
                    System.out.println(YearWastes.sumOfIncome(yearWastes));
                    break;
                case ("4"):
                    break;
                case ("5"):
                    break;
                case ("exit"):
                    System.out.println("Завершение работы");
                    break;
                default:
                    System.out.println("Введены неверные значения\n");
                    break;
            }
        }
    }
}