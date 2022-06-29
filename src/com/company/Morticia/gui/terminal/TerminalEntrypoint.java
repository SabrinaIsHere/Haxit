package com.company.Morticia.gui.terminal;

import com.company.Morticia.EntryPoint;
import com.company.Morticia.gui.GUIEntryPoint;
import com.company.Morticia.helpers.TColor;
import com.company.Morticia.scenarios.Scenario;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminalEntrypoint {
    protected static JPanel centerPanel = new JPanel();
    public static JPanel userInputPanel = new JPanel();

    public static JLabel prefixDisplay = new JLabel("<html>");

    public static void entryPoint(Scenario scenario) {
        JFrame frame = GUIEntryPoint.mainFrame.frame;

        centerPanel.setLayout(new BorderLayout());
        userInputPanel.setLayout(new BorderLayout());

        centerPanel.setBackground(Color.BLACK);
        userInputPanel.setBackground(Color.BLACK);

        JLabel textDisplay = new JLabel("<html>");
        textDisplay.setHorizontalAlignment(SwingConstants.LEFT);
        textDisplay.setVerticalAlignment(SwingConstants.BOTTOM);
        textDisplay.setBackground(Color.BLACK);
        textDisplay.setForeground(Color.WHITE);

        centerPanel.add(textDisplay, BorderLayout.CENTER);

        JTextField inputField = new JTextField() {
            @Override public void setBorder(Border border) {
                // No border
            }
        };
        inputField.setCaretColor(Color.WHITE);

        userInputPanel.add(inputField, BorderLayout.CENTER);
        userInputPanel.add(prefixDisplay, BorderLayout.WEST);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TerminalIO.input.add(inputField.getText());
                TerminalIO.println(TerminalIO.getPrefix() + " " + TColor.WHITE + inputField.getText() + TColor.TERMINATE);
                inputField.setText(null);
                EntryPoint.gameTick();
            }
        });

        inputField.setForeground(Color.WHITE);
        inputField.setBackground(Color.BLACK);

        prefixDisplay.setOpaque(true);
        prefixDisplay.setForeground(Color.WHITE);
        prefixDisplay.setBackground(Color.BLACK);

        GUIEntryPoint.mainFrame.removeAllComponents();
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(userInputPanel, BorderLayout.SOUTH);
        SwingUtilities.updateComponentTreeUI(frame);
    }
}
