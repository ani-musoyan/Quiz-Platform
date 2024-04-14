package am.aua.quiz.questions;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidAnswerException;

public class MultipleChoiceQuestion extends Question {
    private String[] options;
    private int correctOptionIndex;

    public MultipleChoiceQuestion(String questionText, String[] options, int correctOptionIndex) {
        super(questionText);
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    @Override
    public void checkAnswer(String answer) throws InvalidAnswerException {
        char selectedOptionChar = answer.toUpperCase().charAt(0);
        int selectedOptionIndex = selectedOptionChar - 'A';
        if (selectedOptionIndex != correctOptionIndex) {
            throw new InvalidAnswerException("Incorrect answer");
        }
    }

    @Override
    public void askQuestion() {
        super.askQuestion();
        for (String option : options) {
            QuizConsole.displayMessage(option);
        }
        printAnswerFormat();
    }

    @Override
    public String getAnswerFormat() {
        return "a/A";
    }

    @Override
    public String toString() {
        StringBuilder optionsString = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            optionsString.append((char)('A' + i)).append(") ").append(options[i]).append("\n");
        }
        return "Multiple choice question:\n" + super.toString() + "\nOptions:\n" + optionsString.toString();
    }
}
