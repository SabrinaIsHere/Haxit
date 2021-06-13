package com.company.Morticia.menu;

import com.company.Morticia.scenarios.Scenario;
import com.company.Morticia.scenarios.ScenarioRegistry;

import java.util.Scanner;

/**
 * This class is used to select the scenario the player wants to play of those available
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Menu {
    /**
     * This is the entry to the menu, as of now it only selects the scenario which the player would like to player but later there will likely be more features.
     *
     * @return Scenario The scenario which the player chose
     */
    public static Scenario menuEntry() {
        System.out.println("Please select one of the following scenarios by typing in its corresponding number: ");
        int j = 0;
        for (Scenario i : ScenarioRegistry.ScenarioList) {
            j++;
            System.out.println(j + ": " + i.name);
        }

        int input;
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                input = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number");
                continue;
            }
            sc.nextLine();

            if (input <= j && input >= 0) {
                return ScenarioRegistry.ScenarioList.get(input - 1);
            }
        }
    }
}
