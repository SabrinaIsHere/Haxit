package com.company.Morticia;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.menu.Menu;
import com.company.Morticia.menu.Scenario;

import java.util.Scanner;

public class Main {
    public static Computer computer;

    // When done make sure this only starts the library terminal
    public static void main(String[] args) {
        Scenario currScenario = Menu.menuEntry();
        computer = currScenario.playerMachine;

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
