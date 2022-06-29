package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.gui.terminal.TerminalIO;

import java.util.ArrayList;

public class echo extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public echo(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            if (!args.isEmpty()) {
                for (String i : args) {
                    TerminalIO.print(i + " ");
                }
                for (String i : flags) {
                    TerminalIO.print(i + " ");
                }
                TerminalIO.println("");
            }
        } else {
            computer.outputStream.addPrintOutput("Please enter valid parameters. Quitting.");
        }
    }
}
