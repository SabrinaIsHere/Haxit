package com.company.Morticia.helpers;

import java.awt.*;

public enum TColor {
    //Color end string, color reset
    TERMINATE("</font>"),

    BLACK("<font color='black'>"),      // BLACK
    RED("<font color='red'>"),          // RED
    GREEN("<font color='green'>"),      // GREEN
    YELLOW("<font color='yellow'>"),    // YELLOW
    BLUE("<font color='blue'>"),        // BLUE
    LIGHT_BLUE("<font color='04aef7'>"),
    MAGENTA("<font color='magenta'>"),  // MAGENTA
    CYAN("<font color='aqua'>"),        // CYAN
    WHITE("<font color='white'>");      // WHITE

    private final String code;

    TColor(String code) {
        this.code = code;
    }

    public String hex(int color) {
        return "<font color='" + color + "'>";
    }

    @Override
    public String toString() {
        return code;
    }
}