package com.company.Morticia.menu;

import java.util.ArrayList;

public class ScenarioRegistry {
    public static ArrayList<Scenario> ScenarioList = new ArrayList<>();

    public static void registerScenario(Scenario scenario) {
        ScenarioList.add(scenario);
    }

    public static void registerDefaultScenarios() {

    }
}
