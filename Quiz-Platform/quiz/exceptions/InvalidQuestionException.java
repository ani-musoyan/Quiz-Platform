package am.aua.quiz.exceptions;

/**
 * The InvalidQuestionException class represents an exception that is thrown when a question is invalid.
 */
public class InvalidQuestionException extends Exception {

    /**
     * Constructs an InvalidQuestionException with no specified detail message.
     */
    public InvalidQuestionException() {
    }

    /**
     * Constructs an InvalidQuestionException with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidQuestionException(String message) {
        super(message);
    }
}
