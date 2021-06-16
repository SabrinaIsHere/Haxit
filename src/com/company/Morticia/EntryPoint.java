package com.company.Morticia;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.profile.Profile;
import com.company.Morticia.helpers.CommandLineHelper;
import com.company.Morticia.menu.Menu;
import com.company.Morticia.network.NetworkComponent;
import com.company.Morticia.scenarios.Scenario;
import com.company.Morticia.scenarios.ScenarioRegistry;

import java.util.Scanner;

/**
 * This class will serve as the entry point for the library to run the game
 *
 * @author Morticia
 * @version 1.0
 * @since 6/13/21
 */
public class EntryPoint {
    public static boolean doubleTick = false;
    public static Computer originalPlayerMachine;
    public static Computer playerMachine;
    public static Scenario currScenario;

    public static void switchPlayerMachine(Computer newMachine, Profile profile) {
        currScenario.machines.add(playerMachine);
        currScenario.machines.remove(newMachine);
        playerMachine.isPlayerMachine = false;
        playerMachine = newMachine;
        playerMachine.isPlayerMachine = true;
        playerMachine.terminal.currProfile = profile;
    }

    public static void resetPlayerMachine() {
        switchPlayerMachine(originalPlayerMachine, originalPlayerMachine.profiles.get(0));
    }

    /**
     * This method is called by the user to start the game once all the prep, i.e. setting up scenarios, is done.
     *
     * @param initDefaultScenarios Whether or not to initialize the default scenarios before calling the menu
     */
    public static void entryPoint(boolean initDefaultScenarios) {
        if (initDefaultScenarios) {
            ScenarioRegistry.registerDefaultScenarios();
        }

        currScenario = Menu.menuEntry();
        playerMachine = currScenario.playerMachine;
        originalPlayerMachine = currScenario.playerMachine;

        CommandLineHelper.clearCommandLine();

        if (currScenario.networkComponents == null) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                if (!doubleTick) {
                    System.out.print(playerMachine.terminal.terminalPrefix());
                    playerMachine.addInput(sc.nextLine());
                }
                doubleTick = false;
                playerMachine.tick();
                for (Computer i : currScenario.machines) {
                    i.tick();
                }
            }
        } else {
            Scanner sc = new Scanner(System.in);
            while (true) {
                if (!doubleTick) {
                    System.out.print(playerMachine.terminal.terminalPrefix());
                    playerMachine.addInput(sc.nextLine());
                }
                doubleTick = false;
                playerMachine.tick();
                for (Computer i : currScenario.machines) {
                    i.tick();
                }
                for (NetworkComponent i : currScenario.networkComponents) {
                    i.tick();
                }
            }
        }
    }
}
