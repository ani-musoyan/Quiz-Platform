package am.aua.quiz.core;

import am.aua.quiz.exceptions.InvalidQuestionException;
import am.aua.quiz.exceptions.MalformedDatabaseException;
import am.aua.quiz.questions.FillInTheBlankQuestion;
import am.aua.quiz.questions.MultipleChoiceQuestion;
import am.aua.quiz.questions.Question;
import am.aua.quiz.questions.YesNoQuestion;
import am.aua.quiz.topics.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * The QuizDatabase class represents a database of quizzes loaded from a database.txt file.
 */
public class QuizDatabase {
    public static final String databaseFileName = "database.txt";
    private final ArrayList<Topic> topics = new ArrayList<>();

    /**
     * Constructs a QuizDatabase object and loads quizzes from the database file.
     *
     * @throws IOException              if an I/O error occurs.
     * @throws MalformedDatabaseException if the database file is malformed.
     */
    public QuizDatabase() throws IOException, MalformedDatabaseException {
        this.load();
    }

    /**
     * Retrieves the topics in the quiz database.
     *
     * @return The list of topics.
     */
    public ArrayList<Topic> getTopics() {
        return topics;
    }

    /**
     * Loads quizzes from the database file.
     *
     * @throws MalformedDatabaseException if the database file is malformed.
     */
    public void load() throws MalformedDatabaseException {
        File databaseFile = new File(databaseFileName);
        String databaseFileContents;

        TopicGeography topicGeography = new TopicGeography();
        TopicHistory topicHistory = new TopicHistory();
        TopicMovies topicMovies = new TopicMovies();
        TopicSports topicSports = new TopicSports();

        try {
            databaseFileContents = Files.readString(databaseFile.toPath());
        } catch (IOException e) {
            throw new MalformedDatabaseException();
        }
        String[] quizzes = databaseFileContents.split("-\n");
        for (String quizString : quizzes) {
            String[] quizLines = quizString.split("\n");
            String[] quizDescription = quizLines[0].split(":");

            String quizTopic = quizDescription[0];
            String quizName = quizDescription[1];

            String[] quizQuestionParameters;
            String[] quizAnswerOptions;

            String quizQuestionText;
            String quizQuestionType;
            String quizCorrectAnswer;

            ArrayList<Question> questions = new ArrayList<>();
            for (int i = 1; i < quizLines.length; i++) {
                quizQuestionParameters = quizLines[i].split(":");
                quizQuestionType = quizQuestionParameters[0];
                if (!quizQuestionType.equals("yesno") && !quizQuestionType.equals("fillintheblank")) {
                    quizAnswerOptions = quizLines[i + 1].split(":");
                    i++;
                } else {
                    quizAnswerOptions = new String[]{};
                }

                quizQuestionText = quizQuestionParameters[1];
                quizCorrectAnswer = quizQuestionParameters[2];

                switch (quizQuestionType) {
                    case "yesno" -> questions.add(
                            new YesNoQuestion(
                                    quizQuestionText,
                                    Boolean.parseBoolean(quizCorrectAnswer)
                            )
                    );
                    case "multiplechoice" -> questions.add(
                            new MultipleChoiceQuestion(
                                    quizQuestionText,
                                    new ArrayList<>(List.of(quizAnswerOptions)),
                                    Integer.parseInt(quizCorrectAnswer)
                            )
                    );
                    case "fillintheblank" -> questions.add(
                            new FillInTheBlankQuestion(
                                    quizQuestionText,
                                    quizCorrectAnswer
                            )
                    );
                }
            }
            try {
                switch (quizTopic.toLowerCase()) {
                    case "geography" -> topicGeography.addQuiz(
                            new Quiz()
                                    .setName(quizName)
                                    .setQuestions(questions)
                                    .validateQuestions()
                    );
                    case "history" -> topicHistory.addQuiz(
                            new Quiz()
                                    .setName(quizName)
                                    .setQuestions(questions)
                                    .validateQuestions()
                    );
                    case "movies" -> topicMovies.addQuiz(
                            new Quiz()
                                    .setName(quizName)
                                    .setQuestions(questions)
                                    .validateQuestions()
                    );
                    case "sports" -> topicSports.addQuiz(
                            new Quiz()
                                    .setName(quizName)
                                    .setQuestions(questions)
                                    .validateQuestions()
                    );
                }
            } catch (InvalidQuestionException e) {
                throw new RuntimeException("Malformed database");
            }
        }
        topics.add(topicGeography);
        topics.add(topicHistory);
        topics.add(topicMovies);
        topics.add(topicSports);
    }

}
