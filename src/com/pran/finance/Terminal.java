package com.pran.finance;

import java.util.ArrayList;
import java.util.Scanner;

public class Terminal {
    public static void menu() {
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
                    ArrayList<MonthWastes> monthWastes = new ArrayList<>();
                    System.out.println("Введите папку с отчетами: ");
                    path = scanner.nextLine();
                    FileReader.monthlyReport(path, monthWastes);
                    break;
                case ("2"):
                    ArrayList<YearWastes> yearWastes = new ArrayList<>();
                    System.out.println("Введите папку с отчетом: ");
                    path = scanner.nextLine();
                    FileReader.yearlyReport(path, yearWastes);
                    break;
                case ("3"):
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