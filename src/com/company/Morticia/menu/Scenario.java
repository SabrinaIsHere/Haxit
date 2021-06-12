package com.company.Morticia.menu;

import com.company.Morticia.computer.Computer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class serves as a data structure to hold a list of computers which the player can interact with. This is used to delineate between playable scenarios
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Scenario {
    public ArrayList<Computer> machines;
    public Computer playerMachine;
    public String name;

    /**
     * This constructor initializes all of the class members
     *
     * @param machines Machines which will be available to interact with during play
     * @param playerMachine The machine which the player will use to interact with the other provided machines
     * @param name The name of the scenario
     */
    public Scenario(Computer[] machines, Computer playerMachine, String name) {
        this.machines = new ArrayList<>();
        this.machines.addAll(Arrays.asList(machines));
        this.playerMachine = playerMachine;
        this.name = name;
    }
}
