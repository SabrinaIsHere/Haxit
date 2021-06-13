package com.company.Morticia.computer.terminal;


import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.profile.Profile;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.computer.terminal.commands.CommandInterpreter;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;

import java.util.ArrayList;

/**
 * This class is used by the computer to interact with the tasks of processing commands. This is a separate object to the Computer class for the purpose of allowing people to change it in ways they see fit without significant hassle.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Terminal {
    private Profile currProfile;

    private ArrayList<String> inputStream;
    public int inputStreamSize;

    private CommandInterpreter commandInterpreter;

    Computer computer;

    /**
     * The constructor of the terminal class takes two parameters and with them instances the available class members.
     *
     * @param computer This is the computer this terminal object is attached to.
     * @param currProfile This is the current profile of the user using this terminal. If there is no user, assign root to this.
     */
    public Terminal(Computer computer, Profile currProfile) {
        TerminalRegistry.Terminals.add(this);
        this.computer = computer;
        this.commandInterpreter = new CommandInterpreter();
        inputStream = new ArrayList<>();
        this.inputStreamSize = 0;
        this.currProfile = currProfile;
    }

    /**
     * This method will process one of the commands in the list 'inputStream'.
     */
    public void processCommand() {
        if (!inputStream.isEmpty()) {
            commandInterpreter.findAndExecuteCommand(computer, new ProcessedText(inputStream.get(0)), currProfile.privilege);
            inputStream.remove(0);
        }
    }

    /**
     * This method will initialize the commands which are default to standard computers. This is optional.
     */
    public void initDefaultCommands() {
        commandInterpreter.initDefaultCommands();
    }

    /**
     * This method will add a command which can be called to this terminal object.
     *
     * @param command The command which will be able to be executed
     */
    public void addCommand(Command command) {
        commandInterpreter.addCommand(command);
        inputStreamSize = inputStream.size();
    }

    /**
     * This method will add input to the input stream, this command will then be processed on the nect call of 'processCommand()'
     *
     * @param command The command which will be added to the input stream and later executed
     */
    public void addInput(String command) {
        inputStream.add(command);
        inputStreamSize = inputStream.size();
    }

    /**
     * This method will return the prefix to the text the user is typing. For example, 'root $ '
     *
     * @return The terminal prefix
     */
    public String terminalPrefix() {
        return currProfile.username + "$";
    }
}
