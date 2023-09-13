package org.main;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Personnel {
    private final LocalDate endOfInternship;
    private String letterOfAssessment;
    public Intern(String name, String gender, LocalDate dateOfEmployment,LocalDate endOfInternship) {
        super(name, gender, dateOfEmployment);
        this.endOfInternship = endOfInternship;
    }
    public void setLetterOfAssessment(String letterOfAssessment) {
        this.letterOfAssessment = letterOfAssessment;
    }
    @Override
    public String toString() {
        return "\n--------------------" +
                "\nName: " + getName() +
                "\nPersonnel Id: " + getPersonnelId() +
                "\nRole: Intern" +
                "\nGender: " + getGender() +
                "\nDate Of Employment: " + getDateOfEmployment() +
                "\nEnd Of Internship: " + endOfInternship +
                "\nLetter Of Assessment: " + letterOfAssessment +
                "\n--------------------";
    }
    public static void createIntern(String name, String gender,LocalDate dateOfEmployment, LocalDate endDate, List<Personnel> list) {
           try {
               list.add(new Intern(name, gender, dateOfEmployment, endDate));
               MessageFormat.result("Intern added to the system");
           }catch(Exception e){ MessageFormat.error("Something went wrong. Intern was NOT added to the system");}
    }
}
