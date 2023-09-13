package org.menuSystem.menus;

import org.main.*;
import org.menuSystem.Menu;
import org.menuSystem.MenuItem;
import org.menuSystem.MenuSystem;

import java.util.List;

public class EmployeeMenu extends Menu {
    public EmployeeMenu() {
        super("Menu for managing Employees");
        menuItemList = List.of(
                new MenuItem(1, "Register a paid employee", () -> EmployeeDatabase.addEmployeeToDatabase(scanner)),
                new MenuItem(2, "Change the salary of an employee", () -> EmployeeDatabase.changeSalary(scanner)),
                new MenuItem(3, "View a list of all employees", EmployeeDatabase::printAllEmployees),
                new MenuItem(4, "Go back", () -> MenuSystem.setState(new MainMenu())),
                new MenuItem(0, "Quit", () -> System.exit(0)));
    }
}