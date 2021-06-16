package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.filesystem.File;
import com.company.Morticia.computer.filesystem.Folder;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;

import java.util.ArrayList;
import java.util.Scanner;

public class exec extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public exec(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            Folder currFolder = computer.filesystem.currFolder;
            if (!args.isEmpty()) {
                if (currFolder.hasFile(args.get(0))) {
                    if (currFolder.getFile(args.get(0)).extension.equals("exe")) {
                        File<ProcessedText> currFile = currFolder.getFile(args.get(0));
                        formatExecutable(currFile.data);
                        for (ProcessedText i : currFile.data) {
                            // If any arg in the file is [get_input] we will get user input
                            for (int j = 0; j < i.args.size(); j++) {
                                if (i.args.get(j).equals("[get_input]")) {
                                    Scanner sc = new Scanner(System.in);
                                    i.args.set(j, sc.nextLine());
                                }
                            }
                            computer.terminal.addInput(i.toString());
                        }
                    } else {
                        System.out.println("File not executable. Quitting.");
                    }
                }
            } else {
                System.out.println("File not found. Quitting.");
            }
        } else {
            System.out.println("Please enter valid parameters. Quitting.");
        }
    }

    private void formatExecutable(ArrayList<ProcessedText> data) {
        for (ProcessedText i : data) {
            if (!i.args.isEmpty()) {
                for (int j = 0; j < i.args.size(); j++) {
                    if (i.args.get(j).equals("[get_input]")) {
                        Scanner sc = new Scanner(System.in);
                        i.args.set(j, sc.nextLine());
                    }
                }
            }
        }
    }
}
