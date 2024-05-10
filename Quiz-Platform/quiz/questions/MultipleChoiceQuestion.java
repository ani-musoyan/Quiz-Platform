package am.aua.quiz.questions;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidAnswerException;

import java.util.List;

/**
 * Represents a multiple-choice question.
 */
public class MultipleChoiceQuestion extends Question {

    /**
     * Constructs a multiple-choice question with the specified parameters.
     *
     * @param questionText      The text of the question.
     * @param options           The list of options for the question.
     * @param correctOptionIndex The index of the correct option.
     */
    public MultipleChoiceQuestion(String questionText, List<String> options, int correctOptionIndex) {
        super(questionText, options, correctOptionIndex);
    }

    /**
     * Checks if the given answer is correct.
     *
     * @param answer The answer provided by the user.
     * @return true if the answer is correct, false otherwise.
     * @throws InvalidAnswerException If the provided answer is invalid.
     */
    @Override
    public boolean checkAnswer(String answer) throws InvalidAnswerException {
        char selectedOptionChar = answer.toUpperCase().charAt(0);
        int selectedOptionIndex = selectedOptionChar - 'A';
        if (selectedOptionIndex != correctOptionIndex) {
            throw new InvalidAnswerException("Incorrect answer");
        }
        return true;
    }

    /**
     * Asks the multiple-choice question.
     */
    @Override
    public void askQuestion() {
        super.askQuestion();
        for (String option : this.getOptions()) {
            QuizConsole.displayMessage(option);
        }
        printAnswerFormat();
    }

    /**
     * Gets the answer format for the multiple-choice question.
     *
     * @return The answer format.
     */
    @Override
    public String getAnswerFormat() {
        return "a/A";
    }

    /**
     * Returns a string representation of the multiple-choice question.
     *
     * @return A string representation of the multiple-choice question.
     */
    @Override
    public String toString() {
        StringBuilder optionsString = new StringBuilder();
        for (int i = 0; i < getOptions().size(); i++) {
            optionsString.append((char) ('A' + i)).append(") ").append(getOptions().get(i)).append("\n");
        }
        return "Multiple choice question:\n" + super.toString() + "\nOptions:\n" + optionsString.toString();
    }
}
