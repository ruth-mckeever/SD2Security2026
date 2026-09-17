package org.rmck;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkString("validString"));
        System.out.println(checkString("1nval1dStr1ng"));
        System.out.println(checkBinary("1"));
        System.out.println(checkBinary("0"));
        System.out.println(checkBinary("%"));
        System.out.println(checkBinary("a"));
    }

    public static boolean checkString(String inputString){
        String stringPattern = "[a-zA-Z]+";
        if (inputString.matches(stringPattern)){
            return true;
        }
        return false;
    }

    public static boolean checkBinary(String inputString){
        String stringPattern = "[10]+";
        if (inputString.matches(stringPattern)){
            return true;
        }
        return false;
    }
}