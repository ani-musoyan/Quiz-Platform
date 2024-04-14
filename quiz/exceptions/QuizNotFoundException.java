package am.aua.quiz.exceptions;

public class QuizNotFoundException extends Exception{
    public QuizNotFoundException() {
    }

    public QuizNotFoundException(String message) {
        super(message);
    }
}
