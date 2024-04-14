package am.aua.quiz.core;
import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidQuestionException;

import java.util.*;
public class Topic {
    private String name;
    private Quiz[] quizzes;

    public Topic(String name) throws InvalidQuestionException {
        this.name = name;
        if (name.equals("Geography")) {
            quizzes = new Quiz[]{
                    new Quiz("Rivers of the World"),
                    new Quiz("Capitals of the World"),
                    new Quiz("Mountain Ranges"),
                    new Quiz("Oceans and Seas"),
                    new Quiz("Countries and Continents")
            };
        } else if (name.equals("History")) {
            quizzes = new Quiz[]{
                    new Quiz("Ancient Civilizations"),
                    new Quiz("Medieval History"),
                    new Quiz("Age of Exploration"),
                    new Quiz("Industrial Revolution"),
                    new Quiz("World Wars")
            };
        } else if (name.equals("Movies")) {
            quizzes = new Quiz[]{
                    new Quiz("Classic Films"),
                    new Quiz("Modern Classics"),
                    new Quiz("Animated Movies"),
                    new Quiz("Sci-Fi and Fantasy"),
                    new Quiz("Action and Adventure")
            };
        } else if (name.equals("Sports")) {
                quizzes = new Quiz[]{
                        new Quiz("Football (Soccer)"),
                        new Quiz("Basketball"),
                        new Quiz("Tennis"),
                        new Quiz("American Football"),
                        new Quiz("Olympics")
                };
        }
    }

    public String getName() {
        return name;
    }

    public void selectQuiz() {
        QuizConsole.displayMessage("Please select a quiz (1-" + quizzes.length + ") or enter 'random' for a random quiz:");
        for (int i = 0; i < quizzes.length; i++) {
            QuizConsole.displayMessage((i + 1) + ". " + quizzes[i].getName());
        }

        String choice = QuizConsole.getUserInput();
        if (choice.equalsIgnoreCase("random")) {
            int randomIndex = new Random().nextInt(quizzes.length);
            Quiz selectedQuiz = quizzes[randomIndex];
            selectedQuiz.takeQuiz();
        } else {
            int quizIndex = Integer.parseInt(choice);
            if (quizIndex >= 1 && quizIndex <= quizzes.length) {
                Quiz selectedQuiz = quizzes[quizIndex - 1];
                selectedQuiz.takeQuiz();
            } else {
                QuizConsole.displayMessage("Invalid choice. Please select a valid quiz.");
                selectQuiz();
            }
        }
    }
}