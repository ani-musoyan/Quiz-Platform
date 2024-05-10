package am.aua.quiz.gui;

import am.aua.quiz.core.QuizDatabase;
import am.aua.quiz.topics.Topic;

import javax.swing.*;
import java.awt.*;

/**
 * The TopicSelectionWindow class represents a window for selecting a quiz topic.
 * It displays a list of topics retrieved from a QuizDatabase and allows the user to choose one.
 * Upon selection, it opens a QuizSelectionWindow for the chosen topic.
 */
public class TopicSelectionWindow extends MultipleChoiceWindow {
    private QuizDatabase database;

    /**
     * Constructs a TopicSelectionWindow with the specified QuizDatabase.
     *
     * @param database The QuizDatabase containing the topics.
     */
    public TopicSelectionWindow(QuizDatabase database) {
        super("Select Topic");
        this.database = database;
        updateContent();
    }

    /**
     * Updates the content of the window with the available topics from the database.
     */
    @Override
    protected void updateContent() {
        JPanel choicePanel = (JPanel) getContentPane().getComponent(0);
        choicePanel.removeAll();
        choiceGroup = new ButtonGroup();

        // Add radio buttons for each topic in the database
        for (Topic topic : database.getTopics()) {
            JRadioButton radioButton = new JRadioButton(topic.getName());
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
            String selectedTopicName = getSelectedChoice();
            Topic selectedTopic = database.getTopics().stream()
                    .filter(t -> t.getName().equals(selectedTopicName))
                    .findFirst()
                    .orElse(null);
            if (selectedTopic != null) {
                new QuizSelectionWindow(selectedTopic);
                dispose();  // Close the topic selection window after opening the quiz selection window
            }
        });
    }

}
