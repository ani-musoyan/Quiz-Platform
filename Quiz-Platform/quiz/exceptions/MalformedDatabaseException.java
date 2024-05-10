package am.aua.quiz.exceptions;

/**
 * The MalformedDatabaseException class represents an exception that is thrown when the database is malformed.
 */
public class MalformedDatabaseException extends Exception {
    /**
     * Constructs a MalformedDatabaseException with no specified detail message.
     */
    public MalformedDatabaseException() {
    }

    /**
     * Constructs a MalformedDatabaseException with the specified detail message.
     *
     * @param message the detail message.
     */
    public MalformedDatabaseException(String message) {
        super(message);
    }
}
