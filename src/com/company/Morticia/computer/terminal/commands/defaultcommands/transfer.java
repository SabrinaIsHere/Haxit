package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.EntryPoint;
import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.networkinterface.NetworkInterface;
import com.company.Morticia.computer.profile.Profile;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.gui.terminal.TerminalEntrypoint;
import com.company.Morticia.gui.terminal.TerminalIO;
import com.company.Morticia.network.IPAddress;
import com.company.Morticia.network.IPRegistry;
import com.company.Morticia.network.NetworkComponent;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class transfer extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public transfer(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            if (args.size() >= 3) {
                if (IPRegistry.hasEntry(new IPAddress(args.get(0)))) {
                    NetworkComponent destMachine = IPRegistry.getEntry(new IPAddress(args.get(0)));
                    if (destMachine instanceof NetworkInterface) {
                        // TODO: 6/24/21 fix this shit
                        //TerminalIO.println("Are you sure you'd like to switch to " + args.get(0) + "? [y/n]");
                        /*while (true) {
                            String input = "y";//TerminalIO.nextLine(); // next line causing problems
                            if (input.equals("y")) {
                                break;
                            } else if (input.equals("n")) {
                                TerminalIO.println("Cancelled.");
                                return;
                            }
                        }*/
                        Computer destComputer = ((NetworkInterface) destMachine).computer;

                        Profile profile = destComputer.login(args.get(1), args.get(2));
                        if (profile != null) {
                            EntryPoint.switchPlayerMachine(destComputer, profile);
                        } else {
                            TerminalIO.println("Incorrect username or password");
                        }
                    } else {
                        computer.outputStream.addPrintOutput("Machine not transferable");
                    }
                } else {
                    computer.outputStream.addPrintOutput("Invalid IP address");
                }
            } else if (args.size() == 1) {
                if (args.get(0).equals("original")) {
                    EntryPoint.resetPlayerMachine();
                } else {
                    computer.outputStream.addPrintOutput("Usage: [command] [ip] [username] [password]");
                }
            } else {
                computer.outputStream.addPrintOutput("Usage: [command] [ip] [username] [password]");
            }
        } else {
            computer.outputStream.addPrintOutput("Error: Invalid params. Quitting.");
        }
    }
}
