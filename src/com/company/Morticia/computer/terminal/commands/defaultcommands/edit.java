package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.filesystem.File;
import com.company.Morticia.computer.filesystem.Folder;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;
import com.company.Morticia.gui.terminal.TerminalIO;
import com.company.Morticia.helpers.CommandLineHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class edit extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public edit(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            if (!args.isEmpty()) {
                Folder currFolder = computer.filesystem.currFolder;
                if (currFolder.hasFile(args.get(0))) {
                    List<String> name = Arrays.asList(args.get(0).split("\\."));
                    if (name.size() >= 2) {
                        if (name.get(1).equals("txt")) {
                            File<String> newFile = currFolder.getFile(name.get(0) + "." + name.get(1));
                            // TODO: 6/20/21 Update to new GUI
                            CommandLineHelper.fetchLongInput(newFile.data);
                        } else if (name.get(1).equals("exe")) {
                            File<ProcessedText> newFile = currFolder.getFile(name.get(0) + "." + name.get(1));
                            for (ProcessedText i : newFile.data) {
                                TerminalIO.println(i);
                            }
                            concatenateCommandLists(newFile.data, CommandLineHelper.fetchLongInput()); // error here
                        } else {
                            File<String> newFile = currFolder.getFile(name.get(0) + "." + name.get(1));
                            CommandLineHelper.fetchLongInput(newFile.data);
                        }
                    } else {
                        File<String> newFile = currFolder.getFile(name.get(0) + "." + name.get(1));
                        newFile.data = CommandLineHelper.fetchLongInput();
                    }
                } else {
                    String[] name = args.get(0).split("\\.");
                    if (name.length >= 2) {
                        if (name[1].equals("txt")) {
                            File<String> newFile = new File<>(name[0], name[1], currFolder);
                            newFile.data = CommandLineHelper.fetchLongInput();
                            currFolder.addFile(newFile);
                        } else if (name[1].equals("exe")) {
                            File<ProcessedText> newFile = new File<>(name[0], name[1], currFolder);
                            newFile.data = textToCommand(CommandLineHelper.fetchLongInput());
                            currFolder.addFile(newFile);
                        } else {
                            File<String> newFile = new File<>(name[0], name[1], currFolder);
                            newFile.data = CommandLineHelper.fetchLongInput();
                            currFolder.addFile(newFile);
                        }
                    } else {
                        File<String> newFile = new File<>(name[0], "", currFolder);
                        newFile.data = CommandLineHelper.fetchLongInput();
                        currFolder.addFile(newFile);
                    }
                }
            }
        }
    }

    private ArrayList<ProcessedText> textToCommand(ArrayList<String> text) {
        ArrayList<ProcessedText> buffer = new ArrayList<>();
        for (String i : text) {
            buffer.add(new ProcessedText(i));
        }
        return buffer;
    }

    private void concatenateCommandLists(ArrayList<ProcessedText> list1, ArrayList<String> list2) {
        for (String i : list2) {
            list1.add(new ProcessedText(i));
        }
    }
}
