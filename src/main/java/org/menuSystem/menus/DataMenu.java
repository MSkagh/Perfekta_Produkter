package org.menuSystem.menus;

import org.main.*;
import org.menuSystem.Menu;
import org.menuSystem.MenuItem;
import org.menuSystem.MenuSystem;

import java.util.List;


public class DataMenu extends Menu {
    public DataMenu() {
        super("Information Menu");
        menuItemList = List.of(
                new MenuItem(1, "Show total number of personnel in the system", PersonnelDatabase::getTotalNumberOfPersonnel),
                new MenuItem(2, "Average salary of men", () -> EmployeeDatabase.getAverageSalaryByGender("M")),
                new MenuItem(3, "Average salary of women", () -> EmployeeDatabase.getAverageSalaryByGender("F")),
                new MenuItem(4, "A list of all personnel in the system sorted by length of employment", PersonnelDatabase::printByDateEmployed),
                new MenuItem(5, "Go back to Main Menu", () -> MenuSystem.setState(new MainMenu())),
                new MenuItem(0, "Exit the program", () -> System.exit(0))
        );
    }
}
