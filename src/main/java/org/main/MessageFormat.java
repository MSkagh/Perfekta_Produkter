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
        String genderToText = "Male";
        if (gender.equals("F")) genderToText = "Female";
        return genderToText;
    }
}
