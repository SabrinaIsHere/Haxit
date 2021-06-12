package com.company.Morticia.menu;

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

    }
}
