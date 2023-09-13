package org.menuSystem;


import org.main.Input;


import java.util.List;
import java.util.Scanner;

public abstract class Menu implements State {
 static protected List<MenuItem> menuItemList;
 static protected Scanner scanner = new Scanner(System.in);
 protected String menuTitle;
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
@Override
    public void exe() {
        printMenu();
        int option = Input.getInt("Make your selection", scanner);
        for(MenuItem menuItem : menuItemList){
            if (menuItem.getOption() == option) menuItem.run();
        }
    }
    private void printMenu() {
        String output = menuTitle;
        for (MenuItem menuItem : menuItemList) {
        output = output.concat(
                "\n" + menuItem.getOption() + ": " + menuItem.getText()
                );
        }
        System.out.println(output);
    }
}
