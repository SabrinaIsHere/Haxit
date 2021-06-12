package com.company.Morticia.computer.terminal.commands;

import com.company.Morticia.computer.Computer;

import java.util.ArrayList;

/**
 * This class is to be used to define a command which can be run on a machine. New classes are created which extend it and over ride the execute function to create new commands.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Command {
    boolean active;
    String commandName;
    int privilege;

    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public Command(boolean active, String commandName, int privilege) {
        this.active = active;
        this.commandName = commandName;
        this.privilege = privilege;
    }

    /**
     * This method converts the command into a human readable string.
     *
     * @return String The string version of this object is returned.
     */
    @Override
    public String toString() {
        return "Command: active: " + active + "," + "name: " + commandName + "," + "privilege: " + privilege;
    }

    /**
     * This method is called by the terminal when the command is executed.
     *
     * @param computer This is the computer that the command will operate upon
     * @param args These are the arguments which the user passed to the command
     * @param flags These are the flags the user passed to the command, i.e. '-a'
     */
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {

    }

    /**
     * This method determines whether the values passed to a command are valid
     *
     * @param computer Computer to be tested
     * @param args Args to be tested
     * @param flags Flags to be tested
     * @return boolean Whether or not the parameters are valid for use
     */
    public boolean paramsValid(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
       return computer == null || args == null || flags == null;
    }

    /**
     * This method is a getter for the member 'active'.
     *
     * @return boolean active
     */
    public boolean getActive() {
        return active;
    }

    /**
     * This method is a getter for the member 'commandName'.
     *
     * @return String commandName
     */
    public String getCommandName() {
        return commandName;
    }


    /**
     * This is a getter for the member 'privilege'.
     *
     * @return int privilege
     */
    public int getPrivilegeLevel() {
        return privilege;
    }
}
