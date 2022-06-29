package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.process.Process;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.helpers.TColor;
import com.company.Morticia.network.NetworkProcess;

import java.util.ArrayList;

public class processCommand extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public processCommand(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            if (flags.size() == 1) {
                if (flags.get(0).equals("-l")) {
                    for (Process i : computer.processInterface.processes) {
                        if (i.active) {
                            computer.outputStream.addPrintOutput(TColor.WHITE + i.processName + ": " + i.processID + " (active)" + TColor.TERMINATE);
                        } else {
                            computer.outputStream.addPrintOutput(TColor.WHITE + i.processName + ": " + i.processID + "( inactive)" + TColor.TERMINATE);
                        }
                    }
                    for (NetworkProcess i : computer.networkInterface.processInterface.processes) {
                        if (i.active) {
                            computer.outputStream.addPrintOutput(TColor.WHITE + i.processName + ": " + i.processID + " (active)" + TColor.TERMINATE);
                        } else {
                            computer.outputStream.addPrintOutput(TColor.WHITE + i.processName + ": " + i.processID + "( inactive)" + TColor.TERMINATE);
                        }
                    }
                } else {
                    computer.outputStream.addPrintOutput("Error: Please pass a valid argument. Quitting.");
                }
            } else if (args.size() >= 2) {
                if (args.get(0).equals("stop")) {
                    int id;
                    try {
                        id = Integer.parseInt(args.get(1));
                    } catch (Exception e) {
                        computer.outputStream.addPrintOutput("ID not a number. Quitting.");
                        return;
                    }
                    computer.processInterface.stopProcess(id);
                    computer.networkInterface.processInterface.stopProcess(id);
                } else if (args.get(0).equals("start")) {
                    int id;
                    try {
                        id = Integer.parseInt(args.get(1));
                    } catch (Exception e) {
                        computer.outputStream.addPrintOutput("ID not a number. Quitting.");
                        return;
                    }
                    computer.processInterface.startProcess(id);
                    computer.networkInterface.processInterface.startProcess(id);
                } else {
                    computer.outputStream.addPrintOutput("Error: Please pass a valid argument. Quitting.");
                }
            } else {
                computer.outputStream.addPrintOutput("Error: Please pass a valid argument. Quitting.");
            }
        } else {
            computer.outputStream.addPrintOutput("Error: Invalid parameters passed to command. Quitting.");
        }
    }
}
