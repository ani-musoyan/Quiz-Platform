package am.aua.quiz.cli;

import java.util.*;

/**
 * The QuizConsole class provides methods for interacting with the user via the console.
 */
public class QuizConsole {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Displays a message to the console.
     *
     * @param message The message to be displayed.
     */
    public static void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prompts the user to enter a choice within a specified range and returns the choice.
     *
     * @param min The minimum allowed value for the user choice.
     * @param max The maximum allowed value for the user choice.
     * @return The user's choice within the specified range.
     */
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

    /**
     * Retrieves a string input from the user.
     *
     * @return The string input provided by the user.
     */
    public static String getUserInput() {
        return scanner.nextLine();
    }
}
