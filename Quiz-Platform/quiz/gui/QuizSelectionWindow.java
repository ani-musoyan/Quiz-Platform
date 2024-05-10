package am.aua.quiz.gui;

import am.aua.quiz.core.Quiz;
import am.aua.quiz.topics.Topic;

import javax.swing.*;
import java.awt.*;

/**
 * The QuizSelectionWindow class represents a window for selecting a quiz from a specific topic.
 * It extends the MultipleChoiceWindow class and provides functionality to display available quizzes within a topic and select one.
 */
public class QuizSelectionWindow extends MultipleChoiceWindow {
    private Topic topic;

    /**
     * Constructs a QuizSelectionWindow for the specified topic.
     *
     * @param topic The topic containing quizzes to be displayed for selection.
     */
    public QuizSelectionWindow(Topic topic) {
        super("Select Quiz");
        this.topic = topic;
        updateContent();
    }

    /**
     * Updates the content of the window with available quizzes from the topic.
     */
    @Override
    protected void updateContent() {
        JPanel choicePanel = (JPanel) getContentPane().getComponent(0);
        choicePanel.removeAll();  // Clear previous content
        choiceGroup = new ButtonGroup();

        // Add radio buttons for each quiz in the topic
        for (Quiz quiz : topic.getQuizList()) {
            JRadioButton radioButton = new JRadioButton(quiz.getName());
            Font boldFont = radioButton.getFont().deriveFont(Font.BOLD, 16); // Increase font size to 16 and set it to bold
            radioButton.setFont(boldFont);
            radioButton.setForeground(Color.WHITE);
            radioButton.setActionCommand(topic.getName());
            choiceGroup.add(radioButton);
            choicePanel.add(radioButton);
        }

        validate();
        repaint();

        if (selectButton.getActionListeners().length > 0)
            selectButton.removeActionListener(selectButton.getActionListeners()[0]);
        selectButton.addActionListener(e -> {
            String selectedQuizName = getSelectedChoice();
            Quiz selectedQuiz = topic.getQuizList().stream()
                    .filter(q -> q.getName().equals(selectedQuizName))
                    .findFirst()
                    .orElse(null);
            if (selectedQuiz != null) {
                new QuestionWindow(selectedQuiz);
                dispose();  // Close the quiz selection window after opening the question window
            }
        });
    }
}
