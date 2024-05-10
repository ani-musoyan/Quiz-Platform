package am.aua.quiz.topics;

import am.aua.quiz.core.Quiz;

import java.util.List;

/**
 * The Topic interface represents a topic in a quiz platform.
 * It provides methods to add quizzes, retrieve the name of the topic,
 * select a quiz, and get a list of quizzes associated with the topic.
 */
public interface Topic {

    /**
     * Adds a quiz to the topic.
     *
     * @param quiz The quiz to add.
     */
    void addQuiz(Quiz quiz);

    /**
     * Gets the name of the topic.
     *
     * @return The name of the topic.
     */
    String getName();

    /**
     * Selects a quiz from the topic.
     */
    void selectQuiz();

    /**
     * Gets a list of quizzes associated with the topic.
     *
     * @return A list of quizzes.
     */
    List<Quiz> getQuizList();
}
