package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.filesystem.File;
import com.company.Morticia.computer.filesystem.Folder;
import com.company.Morticia.computer.terminal.commands.Command;

import java.util.ArrayList;

public class cat extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public cat(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            if (!args.isEmpty()) {
                Folder currFolder = computer.filesystem.currFolder;
                if (currFolder.hasFile(args.get(0))) {
                    File<?> file = currFolder.getFile(args.get(0));
                    for (Object i : file.data) {
                        computer.outputStream.addPrintOutput(i.toString());
                    }
                } else {
                    computer.outputStream.addPrintOutput("Please enter a valid file or folder to remove.");
                }
            } else {
                computer.outputStream.addPrintOutput("Please enter a valid file.");
            }
        }
    }
}
