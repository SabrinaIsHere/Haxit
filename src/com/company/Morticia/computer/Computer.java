package com.company.Morticia.computer;

import com.company.Morticia.computer.filesystem.Filesystem;
import com.company.Morticia.computer.networkinterface.NetworkInterface;
import com.company.Morticia.computer.profile.Profile;
import com.company.Morticia.computer.terminal.Terminal;
import com.company.Morticia.computer.terminal.commands.Command;

import java.util.ArrayList;

public class Computer {
    public Terminal terminal;
    public Filesystem filesystem;
    public NetworkInterface networkInterface;

    public ArrayList<Profile> profiles;

    public Computer() {
        this.profiles = new ArrayList<>();
        profiles.add(new Profile("root", "root", true));
        this.terminal = new Terminal(this, profiles.get(0));
        this.filesystem = new Filesystem(true);
        this.networkInterface = new NetworkInterface(this);
    }

    public void tick() {
        for (int i = 0; i < terminal.inputStreamSize; i++) {
            terminal.processCommand();
        }
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
