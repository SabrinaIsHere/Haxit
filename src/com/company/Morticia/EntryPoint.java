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
    /**
     * This method is called by the user to start the game once all the prep, i.e. setting up scenarios, is done.
     */
    public static void entryPoint() {
        ScenarioRegistry.registerDefaultScenarios();
        Scenario currScenario = Menu.menuEntry();
        Computer computer = currScenario.playerMachine;

        CommandLineHelper.clearCommandLine();

        Scanner sc = new Scanner(System.in);
        while (true) {
            computer.addInput(sc.nextLine());
            computer.tick();
            for (Computer i : currScenario.machines) {
                i.tick();
            }
        }
    }
}
