package am.aua.quiz.questions;

import am.aua.quiz.exceptions.InvalidAnswerException;

public class YesNoQuestion extends Question {
    private boolean correctAnswer;

    public YesNoQuestion(String questionText, boolean correctAnswer) {
        super(questionText);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void checkAnswer(String answer) throws InvalidAnswerException {
        if ((answer.equalsIgnoreCase("yes") && !correctAnswer) || (answer.equalsIgnoreCase("no") && correctAnswer)) {
            throw new InvalidAnswerException("Incorrect answer");
        }
    }

    @Override
    public String getAnswerFormat() {
        return "yes/YES or no/NO";
    }

    @Override
    public void askQuestion() {
        super.askQuestion();
        printAnswerFormat();
    }

    @Override
    public String toString() {
        return "Yes/no question: " + super.toString();
    }
}
