package com.company.Morticia;

import com.company.Morticia.computer.Computer;

import java.util.Scanner;

public class Main {
    public static Computer computer = new Computer();

    // When done make sure this only starts the library terminal
    public static void main(String[] args) {
        computer.initDefaultCommands();

        while (true) {
            Scanner sc = new Scanner(System.in);
            computer.addInput(sc.nextLine());
            computer.tick();
        }
    }
}
