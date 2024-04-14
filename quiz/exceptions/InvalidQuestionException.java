package am.aua.quiz.exceptions;

public class InvalidQuestionException extends Exception{

    public InvalidQuestionException() {
    }

    public InvalidQuestionException(String message) {
        super(message);
    }
}
