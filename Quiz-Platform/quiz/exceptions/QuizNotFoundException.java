package am.aua.quiz.exceptions;

/**
 * The QuizNotFoundException class represents an exception that is thrown when a quiz is not found.
 */
public class QuizNotFoundException extends Exception {
    /**
     * Constructs a QuizNotFoundException with no specified detail message.
     */
    public QuizNotFoundException() {
    }

    /**
     * Constructs a QuizNotFoundException with the specified detail message.
     *
     * @param message the detail message.
     */
    public QuizNotFoundException(String message) {
        super(message);
    }
}
