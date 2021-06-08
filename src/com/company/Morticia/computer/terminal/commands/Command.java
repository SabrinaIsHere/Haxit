package com.company.Morticia.computer.terminal.commands;

import com.company.Morticia.computer.Computer;

import java.util.ArrayList;

public class Command {
    boolean active;
    String commandName;
    int privilege;

    public Command(boolean active, String commandName, int privilege) {
        this.active = active;
        this.commandName = commandName;
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "Command: active: " + active + "," + "name: " + commandName + "," + "privilege: " + privilege;
    }


    // Code that runs when a terminal executes this command
    void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {

    }

    // Whether or not this command will be executed, so user can activate/deactivate hard coded ones like this
    boolean getActive() {
        return active;
    }

    // Gets name of the command
    String getCommandName() {
        return commandName;
    }

    // What level of privilege you need to execute command, like user would be 0 and supervisor 1 or smth
    int getPrivilegeLevel() {
        return privilege;
    }
}
