package am.aua.quiz;

import am.aua.quiz.core.QuizPlatform;
import am.aua.quiz.exceptions.InvalidQuestionException;

/**
 * The Main class contains the main method to start the quiz platform.
 */
public class Main {

    /**
     * The main method to start the quiz platform.
     *
     * @param args The command-line arguments (not used).
     * @throws InvalidQuestionException If there is an invalid question.
     */
    public static void main(String[] args) throws InvalidQuestionException {
        QuizPlatform quizPlatform = new QuizPlatform();
        quizPlatform.run();
    }
}
