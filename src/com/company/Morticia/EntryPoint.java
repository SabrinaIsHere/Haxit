package com.company.Morticia;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.helpers.CommandLineHelper;
import com.company.Morticia.menu.Menu;
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

    /**
     * This method is called by the user to start the game once all the prep, i.e. setting up scenarios, is done.
     *
     * @param initDefaultScenarios Whether or not to initialize the default scenarios before calling the menu
     */
    public static void entryPoint(boolean initDefaultScenarios) {
        if (initDefaultScenarios) {
            ScenarioRegistry.registerDefaultScenarios();
        }

        Scenario currScenario = Menu.menuEntry();
        Computer computer = currScenario.playerMachine;

        CommandLineHelper.clearCommandLine();

        Scanner sc = new Scanner(System.in);
        while (true) {
            if (!doubleTick) {
                computer.addInput(sc.nextLine());
                doubleTick = false;
            }
            computer.tick();
            for (Computer i : currScenario.machines) {
                i.tick();
            }
        }
    }
}
