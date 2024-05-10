package am.aua.quiz.gui;

import am.aua.quiz.core.Quiz;
import am.aua.quiz.questions.FillInTheBlankQuestion;
import am.aua.quiz.questions.MultipleChoiceQuestion;
import am.aua.quiz.questions.Question;
import am.aua.quiz.questions.YesNoQuestion;

import javax.swing.*;
import java.awt.*;

/**
 * The QuestionWindow class represents a window for displaying and answering quiz questions.
 * It extends the MultipleChoiceWindow class and provides additional functionality for handling various types of questions.
 */
public class QuestionWindow extends MultipleChoiceWindow {
    private Quiz quiz;
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;
    private JTextField textField;  // For fill-in-the-blank questions
    private JLabel questionLabel;  // Label to display the question text

    /**
     * Constructs a QuestionWindow for the specified quiz.
     *
     * @param quiz The quiz object containing questions.
     */
    public QuestionWindow(Quiz quiz) {
        super("Quiz: " + quiz.getName());
        this.quiz = quiz;
        this.textField = new JTextField(20);
        updateContent();
    }

    /**
     * Updates the content of the window with the current question.
     */
    @Override
    protected void updateContent() {
        getContentPane().removeAll();  // Clear previous components
        getContentPane().setBackground(Color.DARK_GRAY); // Set background color to dark gray

        choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));
        choicePanel.setBackground(Color.DARK_GRAY); // Set background color to dark gray

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST; // Align to the top-left corner
        gbc.insets = new Insets(0, 0, 20, 0); // Add padding to the bottom of the question label

        // Add question label
        Question question = quiz.getQuestions().get(currentQuestionIndex);
        questionLabel = new JLabel(question.getQuestionText(), JLabel.LEFT);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size to 20
        questionLabel.setForeground(Color.WHITE); // Set text color to white
        getContentPane().add(questionLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST; // Align to the top-left corner

        // Add choicePanel which may contain radio buttons or text field
        if (question instanceof FillInTheBlankQuestion) {
            textField.setText("");
            choicePanel.add(textField);
        } else {
            choiceGroup = new ButtonGroup();
            for (String option : question.getOptions()) {
                JRadioButton radioButton = new JRadioButton(option);
                Font boldFont = radioButton.getFont().deriveFont(Font.BOLD, 16); // Increase font size to 16 and set it to bold
                radioButton.setFont(boldFont); // Set the new font
                radioButton.setForeground(Color.WHITE); // Set text color to white
                choiceGroup.add(radioButton);
                choicePanel.add(radioButton);
            }
        }

        getContentPane().add(choicePanel, gbc);

        // Reset and add select button
        gbc.gridy = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_END;
        selectButton = new JButton("Select");
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE; // Do not resize horizontally
        gbc.anchor = GridBagConstraints.SOUTHEAST; // Align to the bottom right corner
        gbc.weighty = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        selectButton.addActionListener(e -> handleAnswer(question));
        getContentPane().add(selectButton, gbc);

        validate();
        repaint();
    }

    /**
     * Handles the user's answer to the current question.
     *
     * @param question The current question being answered.
     */
    private void handleAnswer(Question question) {
        boolean isCorrect = false;
        if (question instanceof MultipleChoiceQuestion || question instanceof YesNoQuestion) {
            String selectedOption = getSelectedChoice();
            int selectedIndex = question.getOptions().indexOf(selectedOption);
            isCorrect = selectedIndex == question.getCorrectAnswer();
        } else if (question instanceof FillInTheBlankQuestion) {
            String userAnswer = textField.getText().trim();
            isCorrect = userAnswer.equalsIgnoreCase(question.getOptions().getFirst());
        }

        if (isCorrect) {
            correctAnswersCount++;
        }

        if (currentQuestionIndex < quiz.getQuestions().size() - 1) {
            currentQuestionIndex++;
            updateContent();
        } else {
            new ResultSummaryWindow(quiz.getName(), correctAnswersCount, quiz.getQuestions().size());
            dispose();
        }
    }
}
