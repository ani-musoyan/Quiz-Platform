package am.aua.quiz.exceptions;

/**
 * The InvalidAnswerFormatException class represents an exception that is thrown when an answer format is invalid.
 */
public class InvalidAnswerFormatException extends Exception {
    /**
     * Constructs an InvalidAnswerFormatException with no specified detail message.
     */
    public InvalidAnswerFormatException() {
    }

    /**
     * Constructs an InvalidAnswerFormatException with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidAnswerFormatException(String message) {
        super(message);
    }
}
