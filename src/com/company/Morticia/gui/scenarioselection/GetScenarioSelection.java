package com.company.Morticia.gui.scenarioselection;

import com.company.Morticia.scenarios.Scenario;
import com.company.Morticia.scenarios.ScenarioRegistry;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GetScenarioSelection {
    public static Scenario getScenarioSelection(Component parent) {
        ArrayList<Scenario> scenarios = ScenarioRegistry.ScenarioList;
        ArrayList<Object> possibilites = new ArrayList<>();
        possibilites.add("");

        for (Scenario i : scenarios) {
            possibilites.add(i.name);
        }

        Icon icon = new ImageIcon();
        String input = (String) JOptionPane.showInputDialog(
                parent,
                "Please select a scenario",
                "Scenario Selection",
                JOptionPane.PLAIN_MESSAGE,
                icon,
                possibilites.toArray(),
                "");

        for (Scenario i : scenarios) {
            if (i.name.equals(input)) {
                return i;
            }
        }
        return null;
    }
}
