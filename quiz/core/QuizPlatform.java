package am.aua.quiz.core;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidQuestionException;
import am.aua.quiz.exceptions.QuizNotFoundException;

public class QuizPlatform {
    private Topic[] topics;

    public QuizPlatform() throws InvalidQuestionException {
        topics = new Topic[]{
                new Topic("Geography"),
                new Topic("History"),
                new Topic("Movies"),
                new Topic("Sports")
        };
    }

    public void run() {
        QuizConsole.displayMessage("Welcome to the am.aua.quiz.core.Quiz Platform!");

        try {
            selectTopic();
        } catch (QuizNotFoundException e) {
            QuizConsole.displayMessage(e.getMessage());
        }

        QuizConsole.displayMessage("Thank you for using the am.aua.quiz.core.Quiz Platform!");
    }

    private void selectTopic() throws QuizNotFoundException{
        QuizConsole.displayMessage("Please select a topic:");
        for (int i = 0; i < topics.length; i++) {
            QuizConsole.displayMessage((i + 1) + ". " + topics[i].getName());
        }
        int choice = QuizConsole.getUserChoice(1, topics.length);
        Topic selectedTopic = topics[choice - 1];
        selectedTopic.selectQuiz();
    }
}