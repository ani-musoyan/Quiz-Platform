package am.aua.quiz.questions;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidAnswerException;

public abstract class Question {
    private String questionText;

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public void askQuestion() {
        QuizConsole.displayMessage(questionText);
    }

    // Updated checkAnswer method to throw InvalidAnswerException
    public abstract void checkAnswer(String answer) throws InvalidAnswerException;

    // Abstract method to get answer format
    public abstract String getAnswerFormat();

    // Method to print answer format
    public void printAnswerFormat() {
        QuizConsole.displayMessage("Answer format: " + getAnswerFormat() + " ");
    }
    @Override
    public String toString() {
        return "Question: " + questionText;
    }
}
