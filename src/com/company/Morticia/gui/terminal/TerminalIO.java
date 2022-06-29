package com.company.Morticia.gui.terminal;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;

public class TerminalIO {
    private static final int cmpn = 0;
    protected static ArrayList<String> input = new ArrayList<>();

    public static void println(@NotNull Object arg) {
        String currText = ((JLabel) TerminalEntrypoint.centerPanel.getComponent(cmpn)).getText();
        ((JLabel) TerminalEntrypoint.centerPanel.getComponent(cmpn)).setText(currText + "<br>" + arg.toString());
    }

    public static void print(Object arg) {
        String currText = ((JLabel) TerminalEntrypoint.centerPanel.getComponent(cmpn)).getText();
        ((JLabel) TerminalEntrypoint.centerPanel.getComponent(cmpn)).setText(currText + arg.toString());
    }

    public static String nextLine() {
        while (true) {
            if (input.size() >= 1) {
                SwingUtilities.updateComponentTreeUI(TerminalEntrypoint.userInputPanel);
                String buffer = input.get(0);
                input.remove(0);
                return buffer;
            }
        }
    }

    // TODO: 11/17/21 this lmao 
    public static ArrayList<String> fetchLongInput() {
        return new ArrayList<>();
    }

    public static void clearTerminal() {
        ((JLabel) TerminalEntrypoint.centerPanel.getComponent(cmpn)).setText("<html>");
    }

    private static String prefix = "";
    public static void setPrefix(String newPrefix) {
        prefix = newPrefix;
        TerminalEntrypoint.prefixDisplay.setText("<html>" + prefix + "</html>");
    }

    public static String getPrefix() {
        return prefix;
    }
}
