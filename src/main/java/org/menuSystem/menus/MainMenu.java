package org.menuSystem.menus;

import org.main.PersonnelDatabase;
import org.menuSystem.Menu;
import org.menuSystem.MenuItem;
import org.menuSystem.MenuSystem;

import java.util.List;

public class MainMenu extends Menu {
    public MainMenu() {
        super("Main Menu");
        menuItemList = List.of(
                new MenuItem(1, "Manage employees", () -> MenuSystem.setState(new EmployeeMenu())),
                new MenuItem(2, "Manage interns", () -> MenuSystem.setState(new InternMenu())),
                new MenuItem(3, "Manage a specific individuals personal information", () -> MenuSystem.setState(new PersonalInformationMenu())),
                new MenuItem(4, "View information of employees", () -> MenuSystem.setState(new DataMenu())),
                new MenuItem(5, "Remove personnel from the system", ()-> PersonnelDatabase.removePersonnel(scanner)),
                new MenuItem(0, "Exit the program", () -> System.exit(0))
        );
    }
}
