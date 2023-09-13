package org.main;

public abstract class MessageFormat {
    public static void hr(){
        System.out.println("--------------------");
    }
    public static void result(String message){
        MessageFormat.hr();
        System.out.println(message);
        MessageFormat.hr();
    }
    public static void error(String message){
        MessageFormat.hr();
        System.out.println("!!!--> "+message+" <--!!!");
        MessageFormat.hr();
    }
    public static String genderToText(String gender){
        String genderToText = "male";
        if (gender.equals("F")) genderToText = "female";
        return genderToText;
    }
}
