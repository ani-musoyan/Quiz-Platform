package am.aua.quiz.cli;

import java.util.*;
public class QuizConsole {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static int getUserChoice(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    displayMessage("Please enter a number between " + min + " and " + max);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                displayMessage("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }

    public static String getUserInput() {
        return scanner.nextLine();
    }
}