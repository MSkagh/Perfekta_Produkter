package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class PersonnelDatabase {
    protected static ArrayList<Personnel> personnelList = new ArrayList<>();

    public static ArrayList<Personnel> get(){
        return personnelList;
    }
    public static void printByDateEmployed(){
        List<Personnel> personnelListByDateEmployed = new ArrayList<>(personnelList);
        personnelListByDateEmployed.sort((o1, o2) -> (int) (o1.getDateOfEmploymentEpochDay() - o2.getDateOfEmploymentEpochDay()));
        for (Personnel personnel: personnelListByDateEmployed) {
            System.out.println(personnel.toString());
        }
    }
    public static void getTotalNumberOfPersonnel(){
        MessageFormat.result(String.valueOf(personnelList.size()));
    }
    public static void changePersonnelName(Scanner scanner){
        System.out.println("Enter the Personnel-Id for the individual that has changed name");
        String id = scanner.next();
        for (Personnel personnel: personnelList) {
            if (personnel.getPersonnelId().toString().equals(id)){
                personnel.setName(Input.getName(scanner));
                return;
            }
        }
        MessageFormat.error("Invalid Personnel-Id");
    }
    public static void changePersonnelGender(Scanner scanner){
        System.out.println("Enter the Personnel-Id for the individual that has changed gender");
        String id = scanner.next();
        for (Personnel personnel: personnelList) {
            if (personnel.getPersonnelId().toString().equals(id)){
                personnel.setGender(Input.getGender(scanner));
                return;
            }
        }
        MessageFormat.error("Invalid Personnel-Id");
    }
    public static void removePersonnel(Scanner scanner){
        scanner.nextLine();
        System.out.println("Please enter the Personnel Id for the personnel you would like to remove from the system");
        String id = scanner.nextLine();
        for (Personnel personnel : personnelList) {
            if(personnel.getPersonnelId().toString().equals(id)){
                try {
                    personnelList.remove(personnel);
                    MessageFormat.result("Removed from system");
                }catch(Exception e) {
                    MessageFormat.error("Something went wrong, no changes made to the system");
                }
                return;
            }
        }
        MessageFormat.error("Invalid Personnel-Id");
    }
}

