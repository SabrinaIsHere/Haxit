package com.company.Morticia.gui;

import com.company.Morticia.gui.mainmenu.MainMenu;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public JFrame frame;

    private JPanel centerPanel;
    private JPanel rightPanel;

    public MainFrame() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Haxit");
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.BLACK);

        rightPanel = new JPanel(new FlowLayout(0, 15, 5));
        rightPanel.setBackground(Color.BLACK);
        centerPanel.add(rightPanel, BorderLayout.EAST);

        centerPanel.add(MainMenu.getMainMenu(), BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Haxit");
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 40));
        rightPanel.add(titleLabel);

        frame.add(centerPanel, BorderLayout.CENTER);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void removeAllComponents() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
