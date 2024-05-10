package am.aua.quiz.core;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidQuestionException;
import am.aua.quiz.exceptions.MalformedDatabaseException;
import am.aua.quiz.exceptions.QuizNotFoundException;
import am.aua.quiz.gui.MultipleChoiceWindow;
import am.aua.quiz.gui.TopicSelectionWindow;
import am.aua.quiz.topics.Topic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The QuizPlatform class represents the main platform for running quizzes.
 */
public class QuizPlatform {
    private QuizDatabase quizDatabase;

    /**
     * Constructs a QuizPlatform object and initializes the QuizDatabase.
     *
     * @throws InvalidQuestionException if any question in the database is invalid.
     */
    public QuizPlatform() throws InvalidQuestionException {
        try {
            quizDatabase = new QuizDatabase();
        } catch (IOException e) {
            throw new RuntimeException("Database file not found");
        } catch (MalformedDatabaseException e) {
            throw new RuntimeException("Database file is invalid");
        }
    }

    /**
     * Runs the Quiz Platform.
     */
    public void run() {
        QuizConsole.displayMessage("Welcome to the Quiz Platform!");

        List<String> options = new ArrayList<>();
        for (Topic topic : quizDatabase.getTopics()) options.add(topic.getName());
        new TopicSelectionWindow(quizDatabase);

        QuizConsole.displayMessage("Thank you for using the Quiz Platform!");
    }

    /**
     * Allows the user to select a topic and start a quiz.
     *
     * @throws QuizNotFoundException if the selected quiz is not found.
     */
    private void selectTopic() throws QuizNotFoundException {
        QuizConsole.displayMessage("Please select a topic:");
        for (int i = 0; i < quizDatabase.getTopics().size(); i++) {
            QuizConsole.displayMessage((i + 1) + ". " + quizDatabase.getTopics().get(i).getName());
        }
        int choice = QuizConsole.getUserChoice(1, quizDatabase.getTopics().size());
        Topic selectedTopic = quizDatabase.getTopics().get(choice - 1);
        selectedTopic.selectQuiz();
    }
}
