package org.main;

import java.time.LocalDate;
import java.util.List;

public class Employee extends Personnel {
    private int salary;
    public Employee(String name, String gender, LocalDate dateOfEmployment, int salary) {
        super(name, gender, dateOfEmployment);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "\n--------------------" +
                "\nName: " + getName() +
                "\nPersonnel-Id: " + getPersonnelId() +
                "\nRole: Employee" +
                "\nGender: " + getGender() +
                "\nDate Of Employment: " + getDateOfEmployment() +
                "\nSalary: " + salary +
                "\n--------------------";
    }
    static public void createWorker(String name, String gender, LocalDate dateOfEmployment, int salary, List<Personnel> list) {
        list.add(new Employee(name, gender,dateOfEmployment, salary));
    }
}