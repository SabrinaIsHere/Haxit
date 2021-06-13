package com.company.Morticia.computer.terminal.commands.defaultcommands;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.terminal.commands.Command;
import com.company.Morticia.network.IPAddress;
import com.company.Morticia.network.IPRegistry;
import com.company.Morticia.network.NetworkComponent;
import com.company.Morticia.network.Port;

import java.util.ArrayList;

public class net extends Command {
    /**
     * The constructor for Command initializes the three member variables active, commandName, and privilege.
     *
     * @param active      This is the parameter which determines whether a command is active or not, as in, whether or not it can be executed
     * @param commandName This parameter defines the name of the command, as in, what the terminal must detect in order to call this command
     * @param privilege   This parameter determines the level of privilege the user must have to execute this command, i.e. with privilege 1 only the root could execute it
     */
    public net(boolean active, String commandName, int privilege) {
        super(active, commandName, privilege);
    }

    @Override
    public void execute(Computer computer, ArrayList<String> args, ArrayList<String> flags) {
        if (paramsValid(computer, args, flags)) {
            if (args.isEmpty()) {
                if (!flags.isEmpty()) {
                    if (flags.get(0).equals("-l")) {
                        if (computer.networkInterface.network != null) {
                            System.out.println("Network Devices:");
                            for (NetworkComponent i : computer.networkInterface.network.connectedDevices) {
                                if (!i.ip.ip.equals(computer.networkInterface.ip.ip)) {
                                    System.out.println("  " + i.ip.ip);
                                } else {
                                    System.out.println("  (This) " + i.ip.ip);
                                }
                            }
                        }
                        if (!computer.networkInterface.connectedDevices.isEmpty()) {
                            System.out.println("Connected Devices:");
                            for (NetworkComponent i : computer.networkInterface.network.connectedDevices) {
                                System.out.println("  " + i.ip.ip);
                            }
                        }

                        if (!(computer.networkInterface.network != null || !computer.networkInterface.connectedDevices.isEmpty())) {
                            System.out.println("Error: No connected devices or network. Quitting.");
                        }
                    } else if (flags.get(0).equals("-sip")) {
                        System.out.println(computer.networkInterface.ip.ip);
                    }
                }
            } else {
                if (args.get(0).equals("portscan")) {
                    if (args.size() >= 2) {
                        if (IPRegistry.hasEntry(new IPAddress(args.get(1)))) {
                            for (Port i : IPRegistry.getEntry(new IPAddress(args.get(1))).ports) {
                                System.out.println(i.portNumber + ": " + i.protocolsToString());
                            }
                        } else {
                            System.out.println("Error: Invalid Ip address. Qutting.");
                        }
                    }
                }
            }
            if (args.isEmpty() && flags.isEmpty()) {
                System.out.println("Error: Please pass an argument or flag. Quitting.");
            }
        }
    }
}
