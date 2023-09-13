package org.menuSystem.menus;

import org.main.PersonnelDatabase;
import org.menuSystem.Menu;
import org.menuSystem.MenuItem;
import org.menuSystem.MenuSystem;

import java.util.List;

public class PersonalInformationMenu extends Menu {
    PersonalInformationMenu(){
        super("What would you like to do change");
        menuItemList = List.of(
                new MenuItem(1,"Change name", ()-> PersonnelDatabase.changePersonnelName(scanner) ),
        new MenuItem(2,"Change gender", ()-> PersonnelDatabase.changePersonnelGender(scanner)),
        new MenuItem(3,"Return to the information menu", () -> MenuSystem.setState(new DataMenu()) ),
        new MenuItem(0,"Exit the program", () -> System.exit(0))
        );
    }
}
