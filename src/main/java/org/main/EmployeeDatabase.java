package org.main;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class EmployeeDatabase extends PersonnelDatabase{
  private static final Predicate<Object> isEmployee = o -> o.getClass().equals(Employee.class);
  private static ArrayList<Personnel> employeeList = new ArrayList<>();

   private static void updateDatabase(){
       employeeList = new ArrayList<>(personnelList.stream().filter(isEmployee).toList());
   }
    public static void printAllEmployees(){
        updateDatabase();
        employeeList.forEach((e) -> System.out.println(e.toString()));
    }
    public static void getAverageSalaryByGender(String gender){
        updateDatabase();
        String genderFullText = MessageFormat.genderToText(gender);

        int sizeSalary = employeeList.size();
        int sumSalary = 0;
        for (Personnel employee : employeeList) {
                sumSalary += ((Employee)employee).getSalary();
        }
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
        updateDatabase();
        scanner.nextLine();
        System.out.println("Please enter the Personnel Id for the worker you would like to change the salary for");
        String id = scanner.nextLine();

        for (Personnel employee : employeeList) {
                if(employee.getPersonnelId().toString().equals(id)) {
                    ((Employee)employee).setSalary(Input.getInt("What should their new salary be?", scanner));
                    MessageFormat.result("Salary of " + employee.getName() + " has been updated");
                    return;
                }
        }
        MessageFormat.error("That Personnel-ID is invalid or a non-salaried worker ");
    }
}