package com.company.Morticia.computer.terminal.textprocessing;

import java.util.ArrayList;

/**
 * This class is to be used to automatically convert normal strings into text which can be used to search for and execute a command.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class ProcessedText {
    String command;
    ArrayList<String> args;
    ArrayList<String> flags;

    /**
     * The constructor for this class takes a string as a parameter which will be processed and converted into the three fields command, args, and flags
     *
     * @param textToProcess This is the text which will be used to instance this object
     */
    public ProcessedText(String textToProcess) {
        args = new ArrayList<>();
        flags = new ArrayList<>();

        String []processedText = textToProcess.split(" ");

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

    /**
     * This method is a getter for the member 'command'
     *
     * @return String command
     */
    public String getCommand() {
        return command;
    }

    /**
     * This method is a getter for the member 'args'
     *
     * @return ArrayList\<String> args
     */
    public ArrayList<String> getArgs() {
        return args;
    }

    /**
     * This method is a getter for the member 'flags'
     *
     * @return ArrayList\<String> flags
     */
    public ArrayList<String> getFlags() {
        return flags;
    }
}
