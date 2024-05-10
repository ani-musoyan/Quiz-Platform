package am.aua.quiz.core;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.exceptions.InvalidAnswerException;
import am.aua.quiz.exceptions.InvalidAnswerFormatException;
import am.aua.quiz.exceptions.InvalidQuestionException;
import am.aua.quiz.questions.Question;
import am.aua.quiz.questions.FillInTheBlankQuestion;
import am.aua.quiz.questions.MultipleChoiceQuestion;
import am.aua.quiz.questions.YesNoQuestion;

import java.util.ArrayList;

/**
 * The Quiz class represents a quiz containing various types of questions.
 */
public class Quiz {
    private String name;
    private ArrayList<Question> questions = new ArrayList<>();

    /**
     * Validates the questions of the quiz.
     *
     * @return The validated Quiz object.
     * @throws InvalidQuestionException if any question is null or the question array is null.
     */
    public Quiz validateQuestions() throws InvalidQuestionException {
        if (this.questions == null) {
            throw new InvalidQuestionException("Question array cannot be null.");
        }
        for (Question question : this.questions) {
            if (question == null) {
                throw new InvalidQuestionException("A question object is null.");
            }
        }
        return this;
    }

    /**
     * Constructs an empty Quiz object.
     */
    public Quiz() {

    }

    /**
     * Sets the name of the quiz.
     *
     * @param name The name of the quiz.
     * @return The Quiz object.
     */
    public Quiz setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Retrieves the questions of the quiz.
     *
     * @return The ArrayList of questions.
     */
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    /**
     * Sets the questions of the quiz.
     *
     * @param questions The ArrayList of questions to be set.
     * @return The Quiz object.
     */
    public Quiz setQuestions(ArrayList<Question> questions) {
        this.questions.addAll(questions);
        return this;
    }

    /**
     * Retrieves the name of the quiz.
     *
     * @return The name of the quiz.
     */
    public String getName() {
        return name;
    }

    /**
     * Begins the quiz and interacts with the user to answer the questions.
     */
    public void takeQuiz() {
        int score = 0;
        for (Question question : questions) {
            // Display the question using its overridden toString() method

            // Get user input
            boolean answerIsValid = false;
            while (!answerIsValid) {
                QuizConsole.displayMessage(question.toString());
                String answer = QuizConsole.getUserInput();
                try {
                    // Check if the answer is valid
                    answerIsValid = validateAnswer(question, answer);

                    // Check the answer
                    question.checkAnswer(answer);
                    QuizConsole.displayMessage("Correct!");
                    score++;
                } catch (InvalidAnswerException e) {
                    QuizConsole.displayMessage("Incorrect answer.");
                    answerIsValid = true;
                } catch (RuntimeException e) {
                    QuizConsole.displayMessage("Incorrect.");
                } catch (InvalidAnswerFormatException e) {
                    QuizConsole.displayMessage("Incorrect answer format! Please try again.");
                }
            }
        }
        // Display the quiz
        QuizConsole.displayMessage("Quiz completed. Your score: " + score + "/" + questions.size());
    }

    /**
     * Validates the answer format for different types of questions.
     *
     * @param question The question object.
     * @param answer   The user's answer.
     * @return True if the answer format is valid, otherwise false.
     * @throws InvalidAnswerFormatException if the answer format is invalid.
     * @throws InvalidAnswerException       if the answer is invalid.
     */
    private boolean validateAnswer(Question question, String answer) throws InvalidAnswerFormatException, InvalidAnswerException {
        if (question instanceof YesNoQuestion) {
            if (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                throw new InvalidAnswerFormatException("Invalid answer format.");
            } else return question.checkAnswer(answer);
        } else if (question instanceof MultipleChoiceQuestion) {
            answer = answer.toUpperCase();
            if (!answer.equals("A") && !answer.equals("B") && !answer.equals("C") && !answer.equals("D")) {
                throw new InvalidAnswerFormatException("Invalid answer format.");
            }
            return question.checkAnswer(answer);
        }
        return true;
    }
}
