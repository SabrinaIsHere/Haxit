package com.company.Morticia.computer;

import com.company.Morticia.computer.filesystem.Filesystem;
import com.company.Morticia.computer.networkinterface.NetworkInterface;
import com.company.Morticia.computer.profile.Profile;
import com.company.Morticia.computer.terminal.Terminal;
import com.company.Morticia.computer.terminal.commands.Command;

import java.util.ArrayList;

/**
 * This class is the standard machine, it can be built off of for specialized behavior but it can respond to player input and even automated input and execute actions and commands via interacting with a filesystem and network.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Computer {
    public Terminal terminal;
    public Filesystem filesystem;
    public NetworkInterface networkInterface;

    public ArrayList<Profile> profiles;

    /**
     * This constructor initializes all the class members.
     */
    public Computer() {
        this.profiles = new ArrayList<>();
        profiles.add(new Profile("root", "root", true));
        this.terminal = new Terminal(this, profiles.get(0));
        this.filesystem = new Filesystem(true);
        this.networkInterface = new NetworkInterface(this);
    }

    /**
     * This method is to be called whenever the computer is meant to run, it processes all the commands in it's queue
     */
    public void tick() {
        for (int i = 0; i < terminal.inputStreamSize; i++) {
            terminal.processCommand();
        }
    }

    /**
     * Initializes the commands which are default to a playable machine. Optional.
     */
    public void initDefaultCommands() {
        terminal.initDefaultCommands();
    }

    /**
     * Adds a new command which can be executed
     *
     * @param command Command which will be executable
     */
    public void addCommand(Command command) {
        terminal.addCommand(command);
    }

    /**
     * Adds input to the input queue, this input will be processed on the next call of 'tick()'
     *
     * @param command Command in string form which is to be executed
     */
    public void addInput(String command) {
        terminal.addInput(command);
    }
}
