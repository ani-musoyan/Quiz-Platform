package am.aua.quiz.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Enumeration;

/**
 * The MultipleChoiceWindow class represents a window for displaying multiple-choice questions.
 * It provides a framework for displaying choices and selecting an option.
 */
public abstract class MultipleChoiceWindow extends JFrame {
    protected ButtonGroup choiceGroup;
    protected JButton selectButton;
    protected JPanel choicePanel;  // Panel for choices or input fields

    /**
     * Constructs a MultipleChoiceWindow with the specified title.
     *
     * @param title The title of the window.
     */
    public MultipleChoiceWindow(String title) {
        super(title);
        initializeComponents();
    }

    /**
     * Initializes the components of the window.
     */
    private void initializeComponents() {
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Create an empty titled border
        TitledBorder emptyBorder = BorderFactory.createTitledBorder(
                null,
                "Choices",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        Font defaultFont = new Font("Times New Roman", Font.BOLD, 20);
        emptyBorder.setTitleFont(defaultFont);
        emptyBorder.setTitleColor(Color.WHITE);

        getContentPane().removeAll();  // Clear previous components
        getContentPane().setBackground(Color.DARK_GRAY); // Set background color to dark gray

        // Create the choicePanel
        choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));

        choicePanel.setBorder(emptyBorder);
        choicePanel.setBackground(Color.DARK_GRAY); // Set background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;  // Allocate most space to the content
        add(choicePanel, gbc);

        // Setup constraints for selectButton
        selectButton = new JButton("Select");
        selectButton.setForeground(Color.BLACK);
        selectButton.setPreferredSize(new Dimension(100, 30)); // Set fixed size
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE; // Do not resize horizontally
        gbc.anchor = GridBagConstraints.SOUTHEAST; // Align to the bottom right corner
        gbc.weighty = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(selectButton, gbc);

        setVisible(true);
    }

    /**
     * Updates the content of the window.
     */
    protected abstract void updateContent();

    /**
     * Retrieves the text of the selected choice.
     *
     * @return The text of the selected choice, or null if no choice is selected.
     */
    protected String getSelectedChoice() {
        if (choiceGroup != null) {
            for (Enumeration<AbstractButton> buttons = choiceGroup.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    return button.getText();
                }
            }
        }
        return null;
    }
}
