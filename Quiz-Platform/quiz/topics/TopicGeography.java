package am.aua.quiz.topics;

import am.aua.quiz.cli.QuizConsole;
import am.aua.quiz.core.Quiz;

import java.util.ArrayList;
import java.util.Random;

/**
 * The TopicGeography class represents the Geography topic in the quiz platform.
 * It allows adding quizzes, selecting quizzes, and getting the list of quizzes associated with the Geography topic.
 */
public class TopicGeography implements Topic {

    /** The name of the Geography topic. */
    public static final String name = "Geography";

    /** The list of quizzes associated with the Geography topic. */
    private ArrayList<Quiz> quizList = new ArrayList<>();

    /**
     * Adds a quiz to the Geography topic.
     *
     * @param quiz The quiz to add.
     */
    @Override
    public void addQuiz(Quiz quiz) {
        this.getQuizList().add(quiz);
    }

    /**
     * Gets the name of the Geography topic.
     *
     * @return The name of the Geography topic.
     */
    public String getName() {
        return name;
    }

    /**
     * Selects a quiz from the Geography topic.
     */
    public void selectQuiz() {
        QuizConsole.displayMessage("Please select a quiz (1-" + quizList.size() + ") or enter 'random' for a random quiz:");
        for (int i = 0; i < quizList.size(); i++) {
            QuizConsole.displayMessage((i + 1) + ". " + quizList.get(i).getName());
        }

        String choice = QuizConsole.getUserInput();
        if (choice.equalsIgnoreCase("random")) {
            int randomIndex = new Random().nextInt(quizList.size());
            Quiz selectedQuiz = quizList.get(randomIndex);
            selectedQuiz.takeQuiz();
        } else {
            int quizIndex = Integer.parseInt(choice);
            if (quizIndex >= 1 && quizIndex <= quizList.size()) {
                Quiz selectedQuiz = quizList.get(quizIndex - 1);
                selectedQuiz.takeQuiz();
            } else {
                QuizConsole.displayMessage("Invalid choice. Please select a valid quiz.");
                selectQuiz();
            }
        }
    }

    /**
     * Gets the list of quizzes associated with the Geography topic.
     *
     * @return The list of quizzes.
     */
    public ArrayList<Quiz> getQuizList() {
        return quizList;
    }
}
