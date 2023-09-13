package org.menuSystem.menus;

import org.main.*;
import org.menuSystem.Menu;
import org.menuSystem.MenuItem;
import org.menuSystem.MenuSystem;

import java.util.List;

public class InternMenu extends Menu {
    public InternMenu() {
        super("Main Menu");
        menuItemList = List.of(
                new MenuItem(1, "Register an intern", ()-> InternDatabase.addInternToDatabase(scanner)),
                new MenuItem(2, "Write a letter of assessment", () -> InternDatabase.writeLetterOfAssessment(scanner)),
                new MenuItem(3, "View a list of all interns", InternDatabase::printAllInterns),
                new MenuItem(4, "Return to main menu", () -> MenuSystem.setState(new MainMenu())),
                new MenuItem(0, "Exit the program", () -> System.exit(0))
        );
    }
}
