package com.company.Morticia.menu;

import java.util.Scanner;

public class Menu {
    public static Scenario menuEntry() {
        System.out.println("Please select one of the following scenarios by typing in its corresponding number: ");
        int j = 0;
        for (Scenario i : ScenarioRegistry.ScenarioList) {
            j++;
            System.out.println(j + ": " + i.name);
        }

        while (true) {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();

            if (input <= j && input >= 0) {
                return ScenarioRegistry.ScenarioList.get(input - 1);
            }
        }
    }
}
