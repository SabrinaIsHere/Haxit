package com.company.Morticia.menu;

import com.company.Morticia.computer.Computer;

import java.util.ArrayList;
import java.util.Arrays;

public class Scenario {
    public ArrayList<Computer> machines;
    public Computer playerMachine;
    public String name;

    public Scenario(Computer[] machines, Computer playerMachine, String name) {
        this.machines = new ArrayList<>();
        this.machines.addAll(Arrays.asList(machines));
        this.playerMachine = playerMachine;
        this.name = name;
    }
}
