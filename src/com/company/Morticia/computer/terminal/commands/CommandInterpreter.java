package com.company.Morticia.computer.terminal.commands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.terminal.commands.defaultcommands.*;
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
        commands.add(new cd(true, "cd", 0));
        commands.add(new ls(true, "ls", 0));
        commands.add(new ping(true, "ping", 0));
        commands.add(new sendpacket(true, "sendpacket", 0));
        commands.add(new net(true, "net", 0));
        commands.add(new mkdir(true, "mkdir", 0));
        commands.add(new edit(true, "edit", 0));
        commands.add(new rm(true, "rm", 0));
        commands.add(new clear(true, "clear", 0));
        commands.add(new cat(true, "cat", 0));
        commands.add(new exec(true, "./", 0));
        commands.add(new echo(true, "echo", 0));
        commands.add(new transfer(true, "transfer", 0));
        commands.add(new processCommand(true, "process", 1));
    }

    /**
     * This function will find and execute the command which is passed to it. It searches its internal list of commands, so the commands it searches can be customized based on the machine.
     *
     * @param processedText This is the text which will be used to find the intended command
     * @param privilege This is the privilege level which is to be used to determine whether this is executed
     */
    public void findAndExecuteCommand(Computer machine, ProcessedText processedText, int privilege) {
        for (Command i : commands) {
            if (i.getCommandName().equals(processedText.getCommand()) && i.getActive()) {
                if (i.getPrivilegeLevel() <= privilege) {
                    if (i.active) {
                        i.execute(machine, processedText.getArgs(), processedText.getFlags());
                    }
                } else {
                    machine.outputStream.addPrintOutput("Privilege level not high enough to execute command.");
                }
                return;
            }
        }
        machine.outputStream.addPrintOutput("Command not found: " + processedText.command);
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
