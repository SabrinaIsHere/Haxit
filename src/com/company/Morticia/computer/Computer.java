package com.company.Morticia.computer;

import com.company.Morticia.computer.filesystem.Filesystem;
import com.company.Morticia.computer.networkinterface.NetworkInterface;
import com.company.Morticia.computer.terminal.Terminal;
import com.company.Morticia.computer.terminal.commands.Command;

public class Computer {
    public Terminal terminal;
    public Filesystem filesystem;
    public NetworkInterface networkInterface;

    public Computer() {
        this.terminal = new Terminal(this);
        this.filesystem = new Filesystem(true);
        this.networkInterface = new NetworkInterface(this);
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
