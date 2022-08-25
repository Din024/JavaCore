package com.pran.finance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;


public class FileReader {
    public static String readReport(String path){
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            return null;
        }
    }

    public static void monthlyReport(String path, ArrayList<MonthWastes> monthWastes) {
        for (int i = 1; i < 4; i++) {
            String newPath = path + "\\m.20210" + i + ".csv";
            if (readReport(newPath) != null) {
                String[] fileContents = Objects.requireNonNull(readReport(newPath)).split("\\n");
                for (int j = 1; j < fileContents.length; j++) {
                    String[] line = fileContents[j].split(",");
                    MonthWastes waste = new MonthWastes(line[0], Boolean.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[3].replaceAll("\\r", "")));
                    monthWastes.add(waste);
                }
            } else {
                System.out.println("Невозможно прочитать файл " + newPath);
            }
        }
    }

    public static void yearlyReport(String path, ArrayList<YearWastes> yearWastes) {
        String newPath = path + "\\y.2021.csv";
        if (readReport(newPath) != null) {
            String[] fileContents = Objects.requireNonNull(readReport(newPath)).split("\\n");
            for (int j = 1; j < fileContents.length; j++) {
                String[] line = fileContents[j].split(",");
                YearWastes yearWaste = new YearWastes(line[0], Integer.valueOf(line[1]), Boolean.valueOf(line[2]));
                yearWastes.add(yearWaste);
            }
        } else {
            System.out.println("Невозможно прочитать файл " + newPath);
        }
    }
}
