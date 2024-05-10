package am.aua.quiz.exceptions;

/**
 * The InvalidAnswerException class represents an exception that is thrown when an invalid answer is provided.
 */
public class InvalidAnswerException extends Exception {
    /**
     * Constructs an InvalidAnswerException with no specified detail message.
     */
    public InvalidAnswerException() {
    }

    /**
     * Constructs an InvalidAnswerException with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidAnswerException(String message) {
        super(message);
    }
}
