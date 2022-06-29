package com.company.Morticia.gui.mainmenu;

import com.company.Morticia.EntryPoint;
import com.company.Morticia.gui.scenarioselection.GetScenarioSelection;
import com.company.Morticia.scenarios.Scenario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    public static JPanel getMainMenu() {
        JPanel menuPanel = new JPanel();

        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 0, 5, 3);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        menuPanel.setBackground(Color.GRAY);

        JButton selectScenarioButton = new JButton("Select Scenario");
        JButton scenarioEditor = new JButton("Edit Scenario");

        selectScenarioButton.setFocusable(false);
        scenarioEditor.setFocusable(false);

        scenarioEditor.setPreferredSize(selectScenarioButton.getPreferredSize());

        menuPanel.add(selectScenarioButton, constraints);
        menuPanel.add(scenarioEditor, constraints);

        selectScenarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Scenario scenario = GetScenarioSelection.getScenarioSelection(menuPanel);
                if (scenario != null) {
                    EntryPoint.runMachines(scenario);
                }
            }
        });

        scenarioEditor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Open scenario editor
            }
        });

        return menuPanel;
    }
}
