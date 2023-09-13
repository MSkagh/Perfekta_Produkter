package org.main;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;


public abstract class InternDatabase extends PersonnelDatabase {
    private static final Predicate<Object> isIntern = o -> o.getClass().equals(Intern.class);
    private static ArrayList<Personnel> internList = new ArrayList<>();
    private static void updateDatabase(){
        internList = new ArrayList<>(personnelList.stream().filter(isIntern).toList());
    }
    public static void printAllInterns() {
        updateDatabase();
        internList.forEach(intern -> System.out.println(intern.toString()));
    }
    public static void addInternToDatabase(Scanner scanner) {
        scanner.nextLine();
        String name = Input.getName(scanner);
        String gender = Input.getGender(scanner);
        System.out.println("When will the internship start?");
        LocalDate dateOfEmployment = Input.getDate(scanner);
        System.out.println("When will the internship end?");
        LocalDate endOfInternship = Input.getDate(scanner);
        Intern.createIntern(name, gender, dateOfEmployment, endOfInternship, personnelList);
    }
    public static void writeLetterOfAssessment(Scanner scanner) {
        updateDatabase();
        scanner.nextLine();
        System.out.println("Please enter the Personnel Id for the intern you would like to give a Letter of Assessment");
        String id = scanner.nextLine();

        for (Personnel personnel : internList) {
            if (personnel.getPersonnelId().toString().equals(id)) {
                ((Intern)personnel).setLetterOfAssessment(Input.getString(scanner));
                    MessageFormat.result("Letter of assessment has been assigned to: " + personnel.getName());
                return;
            }
        }
        MessageFormat.error("Personnel-Id is invalid or not an intern");
    }
}