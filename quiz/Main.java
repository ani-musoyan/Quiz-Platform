package am.aua.quiz;

import am.aua.quiz.core.QuizPlatform;
import am.aua.quiz.exceptions.InvalidQuestionException;

public class Main {
    public static void main(String[] args) throws InvalidQuestionException {
        QuizPlatform quizPlatform = new QuizPlatform();
        quizPlatform.run();
    }
}
