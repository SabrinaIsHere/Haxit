package com.company.Morticia.gui;

import javax.swing.*;

public class GUIEntryPoint {
    public static MainFrame mainFrame = new MainFrame();

    public static void startGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame.show();
            }
        });
    }
}
