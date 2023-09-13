package org.main;


import java.time.LocalDate;
import java.util.Scanner;

public abstract class InternDatabase extends PersonnelDatabase {
    public static void printAllInterns() {
        for (Personnel personnel : personnelList) {
            if (personnel.getClass() == Intern.class) System.out.println(personnel);
        }
    }

    public static void addInternToDatabase(Scanner scanner) {
        scanner.nextLine();
        String name = Input.getName(scanner);
        String gender = Input.getGender(scanner);
        System.out.println("When will the internship start?");
        LocalDate dateOfEmployment = Input.getDate(scanner);
        System.out.println("When will the internship end?");
        LocalDate endOfInternship = Input.getDate(scanner);
        Intern.createIntern(name, gender, dateOfEmployment, endOfInternship, PersonnelDatabase.get());
    }

    public static void writeLetterOfAssessment(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please enter the Personnel Id for the intern you would like to give a Letter of Assessment");
        String id = scanner.nextLine();
        for (Personnel personnel : personnelList) {
            if (personnel.getPersonnelId().toString().equals(id)) {
                try {
                    ((Intern) personnel).setLetterOfAssessment(Input.getString(scanner));
                    MessageFormat.result("Letter of assessment has been composed and added to the intern");
                } catch (Exception e) {
                    MessageFormat.error("That personnel is not an intern");
                }
                return;
            }
        }
        MessageFormat.error("Invalid Personnel-Id");
    }
}