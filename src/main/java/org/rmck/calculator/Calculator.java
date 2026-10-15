package org.rmck.calculator;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        do {
            System.out.println("Please enter your calculation:");
            Scanner input = new Scanner(System.in);
            String calculation = input.nextLine();
            System.out.println("This is your calculation: " + calculation);

            RunCalculation(calculation);
        } while (true);
    }
    public static boolean RunCalculation(String input) {

        try {
            //This code could cause an exception
            Double result = 0.0;
            if (input.contains("+")){
                //Addition
                Double num1 = ResolveNumber(input.substring(0, input.indexOf("+")));
                Double num2 = ResolveNumber(input.substring(input.indexOf("+") + 1));

                result = num1 + num2;
            }

            System.out.println("Result: " + result);
            return true;
        }
        catch (Exception ex) {
            System.out.println("Something went wrong with your calculation:");
            System.out.println(ex);
        }

        return false;
    }

    public static Double ResolveNumber(String input) {
        String numString = "";
        //Go through each character in the string
        for(int i = 0; i<input.length(); i++){
            //include numbers and decimal points
            if (Character.isDigit(input.charAt(i)) || (input.charAt(i) == '.')) {
                numString += input.charAt(i);
            }
        }
        return Double.parseDouble(numString);
    }
}
