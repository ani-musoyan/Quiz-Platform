public class Quiz {
    private final String name;
    private final Question[] questions;
    private int questionCount;

    public Quiz(String name,  int maxQuestions) {
        this.name = name;
        this.questions = new Question[maxQuestions] ;
        this.questionCount = 0 ;
    }

    public boolean addQuestion(Question question) {
        if (questionCount < questions.length) {
            questions[questionCount] = question;
            questionCount++;
            return true;
        }
        return false;
    }

    public int calculateScore(String[] userAnswers) {
        int score = 0;
        for (int i = 0; i < questionCount; i++) {
            if (questions[i].checkAnswer(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }


    public void takeQuiz() {
        String[] userAnswers = new String[questionCount];
        for (int i = 0; i < questionCount; i++) {
            questions[i].askQuestion();
            userAnswers[i] = getUserInput(); // We will add it later
        }
        int score = calculateScore(userAnswers);
        displayScore(score);
    }


    private void displayScore(int score) {
        System.out.println("Your score is: " + score + " out of " + questionCount);
    }

    public String getName() {
        return name;
    }
}
