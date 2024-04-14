package am.aua.quiz.questions;

import am.aua.quiz.exceptions.InvalidAnswerException;

public class FillInTheBlankQuestion extends Question {
    private String correctAnswer;

    public FillInTheBlankQuestion(String questionText, String correctAnswer) {
        super(questionText);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void checkAnswer(String answer) throws InvalidAnswerException {
        if (!answer.equalsIgnoreCase(correctAnswer)) {
            throw new InvalidAnswerException("Incorrect answer");
        }
    }

    @Override
    public String getAnswerFormat() {
        return "Type text";
    }

    @Override
    public void askQuestion() {
        super.askQuestion();
        printAnswerFormat();
    }

    @Override
    public String toString() {
        return "Fill in the blank question: " + super.toString();
    }
}
