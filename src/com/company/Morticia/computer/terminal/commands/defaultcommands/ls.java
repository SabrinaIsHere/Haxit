package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.filesystem.File;
import com.company.Morticia.computer.filesystem.Folder;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.helpers.TColor;

import java.util.ArrayList;

public class ls extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public ls(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            for (Folder i : computer.filesystem.currFolder.childFolders) {
                System.out.println(i == null);
                computer.outputStream.addPrintOutput(TColor.LIGHT_BLUE + i.folderName + TColor.TERMINATE);
            }
            for (File<?> i : computer.filesystem.currFolder.childFiles) {
                if (i.extension.equals("exe")) {
                    computer.outputStream.addPrintOutput(TColor.GREEN + i.fileName + "." + i.extension + TColor.TERMINATE);
                } else {
                    if (!i.extension.equals("")) {
                        computer.outputStream.addPrintOutput(TColor.WHITE + i.fileName + "." + i.extension + TColor.TERMINATE);
                    } else {
                        computer.outputStream.addPrintOutput(TColor.WHITE + i.fileName + TColor.TERMINATE);
                    }
                }
            }
        } else {
            computer.outputStream.addPrintOutput("Error: Invalid parameters passed to command. Quitting.");
        }
    }
}
