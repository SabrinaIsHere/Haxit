package com.company.Morticia.computer.terminal;


import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.computer.terminal.commands.CommandInterpreter;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;

import java.util.ArrayList;

public class Terminal {
    private String userName;
    private String rootPassword;

    private ArrayList<String> inputStream;

    private CommandInterpreter commandInterpreter;

    Computer computer;

    public Terminal(Computer computer) {
        TerminalRegistry.Terminals.add(this);
        this.computer = computer;
        this.commandInterpreter = new CommandInterpreter();
        inputStream = new ArrayList<>();
    }

    public void processCommand() {
        if (!inputStream.isEmpty()) {
            commandInterpreter.findAndExecuteCommand(new ProcessedText(inputStream.get(0)), 10);
        }
    }

    public void initDefaultCommands() {
        commandInterpreter.initDefaultCommands();
    }

    public void addCommand(Command command) {
        commandInterpreter.addCommand(command);
    }

    public void addInput(String command) {
        inputStream.add(command);
    }

    // Will be done when file system is up and running
    public String terminalPrefix() {
        return "";
    }
}
