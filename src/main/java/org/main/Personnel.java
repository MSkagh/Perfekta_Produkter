package org.main;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Personnel {
    private final UUID personnelId;
    private String name;
    private String gender;
    private final LocalDate dateOfEmployment;


    public Personnel(String name, String gender, LocalDate dateOfEmployment) {
        this.personnelId = java.util.UUID.randomUUID();
        this.name = name;
        this.gender = gender.toUpperCase();
        this.dateOfEmployment = dateOfEmployment;
    }

    public UUID getPersonnelId() {
        return personnelId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
    public long getDateOfEmploymentEpochDay(){
        return getDateOfEmployment().toEpochDay();
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "\n--------------------" +
               "\nName: " + name +
               "\nPersonnel Id: " + personnelId +
               "\nRole: Personnel" +
               "\nGender: " + gender +
               "\nDate Of Employment: " + dateOfEmployment +
               "\n--------------------";
    }
}
