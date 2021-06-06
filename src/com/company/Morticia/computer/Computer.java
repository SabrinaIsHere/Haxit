package com.company.Morticia.computer;

import com.company.Morticia.computer.terminal.Terminal;
import com.company.Morticia.computer.terminal.commands.Command;

public class Computer {
    Terminal terminal;

    public Computer() {
        this.terminal = new Terminal(this);
    }

    public void tick() {
        terminal.processCommand();
    }

    public void initDefaultCommands() {
        terminal.initDefaultCommands();
    }

    public void addCommand(Command command) {
        terminal.addCommand(command);
    }

    public void addInput(String command) {
        terminal.addInput(command);
    }
}
