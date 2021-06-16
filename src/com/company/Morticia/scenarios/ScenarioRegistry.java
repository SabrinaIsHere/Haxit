package com.company.Morticia.scenarios;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.network.Network;
import com.company.Morticia.network.Port;

import java.util.ArrayList;

/**
 * This class serves as a registry of scenarios which is used to display those available to the player
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class ScenarioRegistry {
    public static ArrayList<Scenario> ScenarioList = new ArrayList<>();

    /**
     * Registers a scenario as available for play
     *
     * @param scenario Scenario which is to be registered
     */
    public static void registerScenario(Scenario scenario) {
        ScenarioList.add(scenario);
    }

    /**
     * Registers the scenarios I've included as default. Optional.
     */
    public static void registerDefaultScenarios() {
        createDefaultScenario1();
        createDefaultScenario2();
    }

    /**
     * This sets up the first default scenario. It's in a function to make it easy to distinguish from other default scenarios.
     */
    private static void createDefaultScenario1() {
        // Init machines
        Computer playerMachine = new Computer(true);
        Computer enemyMachine = new Computer(false);

        // Commands
        playerMachine.initDefaultCommands();
        enemyMachine.initDefaultCommands();

        // Set up networking
        Network network = new Network();

        network.addDevice(playerMachine);
        network.addDevice(enemyMachine);

        playerMachine.networkInterface.initDefaultPorts();
        enemyMachine.networkInterface.initDefaultPorts();

        enemyMachine.networkInterface.ports.add(new Port(5, new int[]{0}));

        registerScenario(new Scenario(new Computer[]{enemyMachine}, playerMachine, "Default Scenario 1"));
    }

    /**
     * This sets up the second default scenario.
     */
    private static void createDefaultScenario2() {

    }
}
