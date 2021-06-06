package com.company.Morticia.computer.terminal.textprocessing;

import java.util.ArrayList;

public class ProcessedText {
    String command;
    ArrayList<String> args;
    ArrayList<String> flags;

    public ProcessedText(String textToProcess) {
        args = new ArrayList<>();
        flags = new ArrayList<>();

        String processedText[] = textToProcess.split(" ");

        command = processedText[0];

        for (int i = 1; i < processedText.length; i++) {
            // if starts with '-' it's a flag, otherwise it's an argument
            if (!processedText[i].startsWith("-")) {
                args.add(processedText[i]);
            } else {
                flags.add(processedText[i]);
            }
        }
    }

    public String getCommand() {
        return command;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public ArrayList<String> getFlags() {
        return flags;
    }
}
