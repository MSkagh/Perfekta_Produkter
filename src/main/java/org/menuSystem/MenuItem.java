package org.menuSystem;

public class MenuItem {
    private final int optionNumber;
    private final String text;
    private final Runnable action;

    public MenuItem(int optionNumber, String text, Runnable action) {
        this.optionNumber = optionNumber;
        this.text = text;
        this.action = action;
    }

    public int getOption() {
        return optionNumber;
    }

    public String getText() {
        return text;
    }

    public void run() {
        action.run();
    }

}
