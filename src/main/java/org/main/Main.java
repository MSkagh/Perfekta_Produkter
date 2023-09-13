package org.main;

import org.menuSystem.menus.MainMenu;
import org.menuSystem.MenuSystem;

public class Main{

    public static void main(String[] args) {
        Test test = new Test();
        test.fillList();
        MenuSystem menuSystem = new MenuSystem(new MainMenu());
        while (true) menuSystem.exe();
    }

}