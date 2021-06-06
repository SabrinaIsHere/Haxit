package com.company.Morticia.computer.terminal.commands;

import com.company.Morticia.Main;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;

import java.util.ArrayList;

public class CommandInterpreter {
    private ArrayList<Command> commands = new ArrayList<>();

    public void initDefaultCommands() {

    }

    public void findAndExecuteCommand(ProcessedText processedText, int privilege) {
        for (Command i : commands) {
            if (i.getCommandName().equals(processedText.getCommand()) && i.getActive()) {
                if (i.getPrivilegeLevel() <= privilege) {
                    i.execute(Main.computer, processedText.getArgs(), processedText.getFlags());
                }
            }
        }
    }

    public void addCommand(Command command) {
        commands.add(command);
    }
}
