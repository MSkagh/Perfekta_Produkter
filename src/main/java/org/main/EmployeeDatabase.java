package org.main;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDatabase extends PersonnelDatabase{
    private static final ArrayList<Employee> employeeList = new ArrayList<>();
    private static void updateEmployeeDatabase(){
        personnelList.forEach(personnel -> {
            if (personnel instanceof Employee) employeeList.add((Employee) personnel);
        });

    }
    public static void printAllEmployees(){
        updateEmployeeDatabase();
        employeeList.forEach(employee -> System.out.println(employee.toString()));
    }
    public static void getAverageSalaryByGender(String gender){
        String genderFullText = MessageFormat.genderToText(gender);

        int sizeSalary = employeeList.size();
        int sumSalary = 0;
        for (Employee employee: employeeList) {sumSalary += employee.getSalary();}

        try {
            MessageFormat.result("Average salary of "+genderFullText+":\n" +
                    Arithmetic.averageOf(sumSalary, sizeSalary));
        }catch(Exception e) {
            MessageFormat.error("Data not available");
        }
    }
    public static void addEmployeeToDatabase(Scanner scanner) {
        scanner.nextLine();
        String name = Input.getName(scanner);
        String gender = Input.getGender(scanner);
        int salary = Input.getInt("Please state the agreed upon salary of the new employee", scanner);
        LocalDate dateOfEmployment = Input.getDate(scanner);

        if (!name.equals("")) {
            Employee.createWorker(name, gender, dateOfEmployment, salary, personnelList);
            MessageFormat.result("Employee added to the system");
        } else {
            MessageFormat.error("All fields must be filled in");
        }
    }
    public static void changeSalary(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Please enter the Personnel Id for the worker you would like to change the salary for");
        String id = scanner.nextLine();
        for (Employee employee : employeeList) {
            if(employee.getPersonnelId().toString().equals(id)) {
                employee.setSalary(Input.getInt("What should their new salary be?", scanner));
                MessageFormat.result("Salary of " +id + "has been updated");

            }else MessageFormat.error("Invalid Personnel-Id or non-salaried worker");
        }
    }
}
