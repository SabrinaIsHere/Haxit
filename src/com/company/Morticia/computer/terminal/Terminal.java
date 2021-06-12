package com.company.Morticia.computer.terminal;


import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.profile.Profile;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.computer.terminal.commands.CommandInterpreter;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;

import java.util.ArrayList;

public class Terminal {
    private Profile currProfile;

    private ArrayList<String> inputStream;
    public int inputStreamSize;

    private CommandInterpreter commandInterpreter;

    Computer computer;

    public Terminal(Computer computer, Profile currProfile) {
        TerminalRegistry.Terminals.add(this);
        this.computer = computer;
        this.commandInterpreter = new CommandInterpreter();
        inputStream = new ArrayList<>();
        this.inputStreamSize = 0;
        this.currProfile = currProfile;
    }

    public void processCommand() {
        if (!inputStream.isEmpty()) {
            commandInterpreter.findAndExecuteCommand(new ProcessedText(inputStream.get(0)), currProfile.privilege);
        }
    }

    public void initDefaultCommands() {
        commandInterpreter.initDefaultCommands();
    }

    public void addCommand(Command command) {
        commandInterpreter.addCommand(command);
        inputStreamSize = inputStream.size();
    }

    public void addInput(String command) {
        inputStream.add(command);
        inputStreamSize = inputStream.size();
    }

    // Will be done when file system is up and running
    public String terminalPrefix() {
        return currProfile.username + "$";
    }
}
