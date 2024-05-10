package am.aua.quiz.questions;

import am.aua.quiz.exceptions.InvalidAnswerException;

import java.util.List;

/**
 * The FillInTheBlankQuestion class represents a question where the user needs to fill in the blank with the correct answer.
 * It extends the Question class and implements the functionality for checking the answer.
 */
public class FillInTheBlankQuestion extends Question {
    private String correctAnswer;

    /**
     * Constructs a FillInTheBlankQuestion with the specified question text and correct answer.
     *
     * @param questionText  The text of the question.
     * @param correctAnswer The correct answer to the question.
     */
    public FillInTheBlankQuestion(String questionText, String correctAnswer) {
        super(questionText, List.of(correctAnswer), 0);
        this.correctAnswer = correctAnswer;
    }

    /**
     * Checks whether the provided answer is correct for this fill-in-the-blank question.
     *
     * @param answer The user's answer to the question.
     * @return True if the answer is correct, false otherwise.
     * @throws InvalidAnswerException If the answer format is invalid.
     */
    @Override
    public boolean checkAnswer(String answer) throws InvalidAnswerException {
        if (!answer.equalsIgnoreCase(correctAnswer)) {
            throw new InvalidAnswerException("Incorrect answer");
        }
        return true;
    }

    /**
     * Gets the answer format for this fill-in-the-blank question.
     *
     * @return The answer format (i.e., "Type text").
     */
    @Override
    public String getAnswerFormat() {
        return "Type text";
    }

    /**
     * Displays the question, along with the answer format.
     */
    @Override
    public void askQuestion() {
        super.askQuestion();
        printAnswerFormat();
    }

    /**
     * Generates a string representation of this fill-in-the-blank question.
     *
     * @return A string describing the question.
     */
    @Override
    public String toString() {
        return "Fill in the blank question: " + super.toString();
    }
}
