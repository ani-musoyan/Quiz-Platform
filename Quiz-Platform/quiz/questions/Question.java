package am.aua.quiz.questions;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidAnswerException;

import java.util.List;

/**
 * The Question class represents a generic quiz question.
 * It provides methods to ask, check the answer, and get answer format.
 */
public abstract class Question {

    private String questionText;
     List<String> answerOptions;
     int correctOptionIndex;

    /**
     * Constructs a Question with the specified question text, answer options, and index of the correct option.
     *
     * @param questionText       The text of the question.
     * @param answerOptions      The list of answer options for the question.
     * @param correctOptionIndex The index of the correct option in the answer options list.
     */
    public Question(String questionText, List<String> answerOptions, int correctOptionIndex) {
        this.questionText = questionText;
        this.answerOptions = answerOptions;
        this.correctOptionIndex = correctOptionIndex;
    }

    /**
     * Asks the question by displaying its text.
     */
    public void askQuestion() {
        QuizConsole.displayMessage(questionText);
    }

    /**
     * Checks whether the provided answer is correct for this question.
     *
     * @param answer The user's answer to the question.
     * @return True if the answer is correct, false otherwise.
     * @throws InvalidAnswerException If the answer format is invalid.
     */
    public abstract boolean checkAnswer(String answer) throws InvalidAnswerException;

    /**
     * Gets the answer format for this question.
     *
     * @return The answer format.
     */
    public abstract String getAnswerFormat();

    /**
     * Gets the text of the question.
     *
     * @return The text of the question.
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Gets the list of answer options for the question.
     *
     * @return The list of answer options.
     */
    public List<String> getOptions() {
        return answerOptions;
    }

    /**
     * Gets the index of the correct answer option in the list of answer options.
     *
     * @return The index of the correct answer option.
     */
    public int getCorrectAnswer() {
        return correctOptionIndex;
    }

    /**
     * Prints the answer format of the question.
     */
    public void printAnswerFormat() {
        QuizConsole.displayMessage("Answer format: " + getAnswerFormat() + " ");
    }

    /**
     * Generates a string representation of this question.
     *
     * @return A string describing the question.
     */
    @Override
    public String toString() {
        return "Question: " + questionText;
    }
}
