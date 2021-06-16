package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.network.IPAddress;
import com.company.Morticia.network.IPRegistry;
import com.company.Morticia.network.Packet;

import java.util.ArrayList;

public class ping extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public ping(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            if (IPRegistry.hasEntry(new IPAddress(args.get(0)))) {
                IPRegistry.getEntry(new IPAddress(args.get(0))).handlePacket(new Packet(computer, new IPAddress(args.get(0)), 0, 0, 1, "0"));
            } else {
                computer.outputStream.addPrintOutput("Invalid Ip adress. Quitting.");
            }
        } else {
            computer.outputStream.addPrintOutput("Error: invalid parameters passed to command. Quitting.");
        }
    }
}
