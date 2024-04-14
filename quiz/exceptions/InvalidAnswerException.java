package am.aua.quiz.exceptions;

public class InvalidAnswerException extends Exception{
    public InvalidAnswerException() {
    }

    public InvalidAnswerException(String message) {
        super(message);
    }
}
