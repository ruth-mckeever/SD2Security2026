package org.rmck.Password;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Password {
    private static String SECURE_PASSWORD = "A*B#654Xcx";
    private static int timeout = 0;
    private static int totalAttempts = 0;

    public static void main(String[] args) {
        Password password = new Password();
        boolean authenticated = password.requestPassword();
        if (authenticated){
            System.out.println("You're in!");
            System.out.println("Should be printing the contents of the text file here...");
        }
    }
    public boolean requestPassword() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your password");
        String passwordInput = keyboard.nextLine();

        if(passwordInput.equals(SECURE_PASSWORD)) {
            totalAttempts = 0;
            timeout = 0;
            return true;
        }
        else {
            totalAttempts++;
            System.out.println("Incorrect Password. Total attempts: " + totalAttempts);
            if (totalAttempts == 3){
                timeout = 30;
                System.out.println("Too many attempts. Try again later. Timeout set to: " + timeout);
                callTimeout(timeout);
            } else if (totalAttempts % 3 == 0) {
                timeout = timeout * 2;
                System.out.println("Too many attempts. Try again later. Timeout set to: " + timeout);
                callTimeout(timeout);
            }
            requestPassword(); //Recursion...
        }
        return false;
    }

    private void callTimeout(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        }
        catch (InterruptedException ex) {
            System.out.println("Timeout interrupted");
        }
    }
}
