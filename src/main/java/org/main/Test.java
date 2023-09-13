package org.main;

import java.time.LocalDate;
public class Test {

 public void fillList() {
     PersonnelDatabase.personnelList.add(new Employee("Jens", "M", LocalDate.of(1998,9,27), 5000));
     PersonnelDatabase.personnelList.add(new Employee("Arne", "M", LocalDate.of(1998,8,27), 5500));
     PersonnelDatabase.personnelList.add(new Employee("Bella", "F", LocalDate.of(1998,1,27), 4999));
     PersonnelDatabase.personnelList.add(new Intern("Sally", "f", LocalDate.of(1998, 9,26), LocalDate.of(2023, 11,30)));
     PersonnelDatabase.personnelList.add(new Intern("Ewa", "f", LocalDate.of(1998, 9,29), LocalDate.of(2024, 5,30)));
     PersonnelDatabase.personnelList.add(new Intern("Bherang", "m", LocalDate.of(2013, 1,26), LocalDate.of(2023, 9,30)));
     }
}

