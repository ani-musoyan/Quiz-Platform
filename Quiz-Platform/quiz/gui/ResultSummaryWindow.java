package am.aua.quiz.gui;

import javax.swing.*;
import java.awt.*;

/**
 * The ResultSummaryWindow class represents a window displaying the summary of a quiz result.
 * It shows the user's score, percentage, and provides an option to close the window.
 */
public class ResultSummaryWindow extends JFrame {
    /**
     * Constructs a ResultSummaryWindow with the specified quiz result details.
     *
     * @param quizName       The name of the completed quiz.
     * @param correctAnswers The number of correct answers.
     * @param totalQuestions The total number of questions in the quiz.
     */
    public ResultSummaryWindow(String quizName, int correctAnswers, int totalQuestions) {

        super("Quiz Completed: " + quizName);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        getContentPane().setBackground(Color.DARK_GRAY);

        JLabel resultLabel = new JLabel("Your Score: " + correctAnswers + "/" + totalQuestions);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setForeground(Color.WHITE);
        add(resultLabel);

        JLabel percentageLabel = new JLabel("Percentage: " + (int) ((double) correctAnswers / totalQuestions * 100) + "%");
        percentageLabel.setHorizontalAlignment(JLabel.CENTER);
        percentageLabel.setForeground(Color.WHITE);
        add(percentageLabel);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        closeButton.setForeground(Color.BLACK);
        add(closeButton);

        setVisible(true);
    }
}
