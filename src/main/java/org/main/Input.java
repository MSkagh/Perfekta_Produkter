package org.main;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
public class Input {
    private Input(){}
    public static String getString(Scanner scanner){
        System.out.println("Enter a fitting text");
        return scanner.nextLine();
    }
    public static int getInt(String message, Scanner scanner){
        System.out.println(message);
        for (;;) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
               MessageFormat.error("Please provide a number");
                scanner.next();
            }
        }
    }
    public static String getName(Scanner scanner){
        System.out.println("Please provide a name");
        return scanner.nextLine();
    }
    public static String getGender(Scanner scanner){
        boolean parsing = true;
        String gender;
        do{
            System.out.println("Please enter a gender (M/F)");
            if (scanner.hasNext("[mfMF]")) {parsing = false;
            }
            gender = scanner.nextLine();
        }while(parsing);
        return gender;
    }
    public static LocalDate getDate(Scanner scanner){
        boolean parsing = true;

        int year = 0;
        int month = 0;
        int day = 0;

        do{
            System.out.println("Please enter a date (YYYYMMDD)");
            String rawInput = scanner.nextLine();
            if (rawInput.matches("[0-9]{8}")) {
                year = parseInt(rawInput.substring(0,4));
                month = parseInt(rawInput.substring(4, 6));
                day = parseInt(rawInput.substring(6,8));

                if(month < 13 && day < 32) {
                    parsing = false;
                } else {MessageFormat.error("Invalid date");}
            }
        }while(parsing);

        return LocalDate.of(year, month, day);
    }
}
