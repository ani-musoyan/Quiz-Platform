package am.aua.quiz.questions;

import am.aua.quiz.exceptions.InvalidAnswerException;

import java.util.List;

/**
 * The YesNoQuestion class represents a question that requires a yes or no answer.
 * It inherits from the Question class.
 */
public class YesNoQuestion extends Question {

    /**
     * Constructs a YesNoQuestion with the specified question text and correct answer.
     *
     * @param questionText   The text of the question.
     * @param correctAnswer  The correct answer to the question (true for yes, false for no).
     */
    public YesNoQuestion(String questionText, boolean correctAnswer) {
        super(questionText, List.of("Yes", "No"), correctAnswer ? 0 : 1);
    }

    /**
     * Checks whether the provided answer is correct for this yes/no question.
     *
     * @param answer The user's answer to the question.
     * @return True if the answer is correct, false otherwise.
     * @throws InvalidAnswerException If the answer format is invalid.
     */
    @Override
    public boolean checkAnswer(String answer) throws InvalidAnswerException {
        if ((answer.equalsIgnoreCase("yes") && this.getCorrectAnswer() != 0) || (answer.equalsIgnoreCase("no") && this.getCorrectAnswer() != 1)) {
            throw new InvalidAnswerException("Incorrect answer");
        }
        return true;
    }

    /**
     * Gets the answer format for this yes/no question.
     *
     * @return The answer format ("yes/YES or no/NO").
     */
    @Override
    public String getAnswerFormat() {
        return "yes/YES or no/NO";
    }

    /**
     * Asks the yes/no question by displaying its text and answer format.
     */
    @Override
    public void askQuestion() {
        super.askQuestion();
        printAnswerFormat();
    }

    /**
     * Generates a string representation of this yes/no question.
     *
     * @return A string describing the yes/no question.
     */
    @Override
    public String toString() {
        return "Yes/no question: " + super.toString();
    }
}
