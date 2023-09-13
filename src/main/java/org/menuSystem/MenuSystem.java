package org.menuSystem;

public class MenuSystem implements State{
    private static State currentState;

    public MenuSystem(State currentState){
        MenuSystem.currentState = currentState;
    }

    public static void setState(State newState) {
        currentState = newState;
    }

    @Override
    public void exe() {
        currentState.exe();
    }
}
