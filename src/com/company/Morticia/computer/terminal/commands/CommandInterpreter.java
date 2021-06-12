package com.company.Morticia.computer.terminal.commands;

import com.company.Morticia.Main;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;

import java.util.ArrayList;

/**
 * This purpose of this class is to interpret and execute commands.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class CommandInterpreter {
    private ArrayList<Command> commands = new ArrayList<>();

    /**
     * This method will initialize and add a number of commands which would be commonly found in a bash shell.
     */
    public void initDefaultCommands() {

    }

    /**
     * This function will find and execute the command which is passed to it. It searches its internal list of commands, so the commands it searches can be customized based on the machine.
     *
     * @param processedText This is the text which will be used to find the intended command
     * @param privilege This is the privilege level which is to be used to determine whether this is executed
     */
    public void findAndExecuteCommand(ProcessedText processedText, int privilege) {
        for (Command i : commands) {
            if (i.getCommandName().equals(processedText.getCommand()) && i.getActive()) {
                if (i.getPrivilegeLevel() <= privilege) {
                    i.execute(Main.computer, processedText.getArgs(), processedText.getFlags());
                }
            }
        }
    }

    /**
     * This method adds to the list of available commands in this instance.
     *
     * @param command The command to be added to those available
     */
    public void addCommand(Command command) {
        commands.add(command);
    }
}
