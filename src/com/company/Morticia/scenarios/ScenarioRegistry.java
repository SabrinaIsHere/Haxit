package com.company.Morticia.scenarios;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.filesystem.File;
import com.company.Morticia.computer.filesystem.Folder;
import com.company.Morticia.computer.profile.Profile;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;
import com.company.Morticia.network.Network;
import com.company.Morticia.network.NetworkComponent;
import com.company.Morticia.network.Port;
import com.company.Morticia.scenarios.defaultscenario2files.ThermostatProcess;

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
        /*
        Scenario design notes:
          - Home network
          - Player is trying to steal data
          - Player is trying to gain root access

        Network device list:
          - Dad's work computer
          - Child's new badly configured and insecure computer
          - Mom's work laptop
          - Networked thermostat which can be controlled by any of the computers and sends temperature data to be displayed
         */

        // Init machines
        Computer playerMachine = new Computer(true);

        Computer dadsMachine = new Computer(false);
        Computer momsMachine = new Computer(false);
        Computer kidsMachine = new Computer(false);

        NetworkComponent thermostat = new NetworkComponent();
        thermostat.processInterface.addProcess(new ThermostatProcess(thermostat));

        // Commands
        playerMachine.initDefaultCommands();

        dadsMachine.initDefaultCommands();
        momsMachine.initDefaultCommands();
        kidsMachine.initDefaultCommands();

        // Networking
        Network homeNetwork = new Network();

        playerMachine.networkInterface.initDefaultPorts();

        dadsMachine.networkInterface.initDefaultPorts();
        momsMachine.networkInterface.initDefaultPorts();
        kidsMachine.networkInterface.initDefaultPorts();

        thermostat.ports.add(new Port(100, new int[]{43, 44}));

        homeNetwork.addDevice(dadsMachine);
        homeNetwork.addDevice(momsMachine);
        homeNetwork.addDevice(kidsMachine);
        homeNetwork.addDevice(thermostat);

        // Profiles
        dadsMachine.profiles.get(0).password = "20f60";
        dadsMachine.profiles.add(new Profile("JohnElliot", "1234", false));

        momsMachine.profiles.get(0).password = "hello123";
        momsMachine.profiles.add(new Profile("SamanthaElliot", "hello123", false));

        // Files
        // Email
        String kidIP = kidsMachine.networkInterface.ip.ip;
        Folder emailsFolder = new Folder(playerMachine.filesystem.root.getFolder("Home"), "Emails");
        File<String> email = new File<>("email1", "txt", emailsFolder);

        email.data.add("Hey so I know you're busy, but I found a new job for you.");
        email.data.add("I know I know, you want out, but this one is really easy and I heard you needed some cash.");
        email.data.add("Some rich folks moved in near me and it looks like their kid has a new computer.");
        email.data.add("Needless to say, the kid probably hasn't configured it very well and I bet there's an insecurity");
        email.data.add("if you're willing to look for it. Anyway, good to talk again.");
        email.data.add("");
        email.data.add("Kids IP: " + kidIP);

        System.out.println(kidIP); // Remove this later
        System.out.println(thermostat.ip.ip);

        emailsFolder.addFile(email);
        playerMachine.filesystem.root.getFolder("Home").addFolder(emailsFolder);

        // Ping thermostat script
        File<ProcessedText> thermostatPingScript = new File<>("ping_thermostat", "exe", kidsMachine.filesystem.root.getFolder("bin"));

        thermostatPingScript.data.add(new ProcessedText("echo Type Input: [get/set [temperature]/on/off]"));
        thermostatPingScript.data.add(new ProcessedText("sendpacket " + thermostat.ip.ip + " 100 100 43 [get_input]"));

        kidsMachine.filesystem.root.getFolder("bin").addFile(thermostatPingScript);

        // Thermostat instruction manual
        File<String> thermostatInstructionManual = new File<>("Thermo900_Instruction_Manual", "txt", kidsMachine.filesystem.root.getFolder("Home"));

        thermostatInstructionManual.data.add("Welcome to the instruction manual for your new Thermo900!");
        thermostatInstructionManual.data.add("This one stop shop for everything networked thermostat will have all the documentation you need to get");
        thermostatInstructionManual.data.add("your households heating automated.");
        thermostatInstructionManual.data.add("");
        thermostatInstructionManual.data.add("The first think you'll want to do is ping your thermostat.");
        thermostatInstructionManual.data.add("If your system supports it, try sendpacket [ip] 100 100 43 [command] in your command prompt.");
        thermostatInstructionManual.data.add("The commands are: get, set, on, and off.");
        thermostatInstructionManual.data.add("Get gets the temperature, set sets the goal temperature, on turns on the thermostat and off turns off the thermostat.");
        thermostatInstructionManual.data.add("And, as a bonus security feature, you can even get the names of everyone connected to the device");
        thermostatInstructionManual.data.add(" with the simple command sendpacket [ip] 100 100 44 get_connectedDevices!");

        kidsMachine.filesystem.root.getFolder("Home").addFile(thermostatInstructionManual);

        // Win scenario file
        File<String> winFile = new File<>("innocuous_file", "txt", dadsMachine.filesystem.root.getFolder("Home"));

        winFile.data.add("Bank Acct Username: John Elliot");
        winFile.data.add("Bank Acct Password: fAfdsD342dF4RWF@#WDFS");

        dadsMachine.filesystem.root.getFolder("Home").addFile(winFile);

        // Mom file
        File<String> momFile = new File<>("Divorce_Papers", "txt", momsMachine.filesystem.root.getFolder("Home"));

        momFile.data.add("Error: File not in standard UTF-8 format. Can not read file. Quitting.");

        momsMachine.filesystem.root.getFolder("Home").addFile(momFile);

        // Init and add scenario
        registerScenario(new Scenario(new Computer[]{dadsMachine, momsMachine, kidsMachine}, new NetworkComponent[]{thermostat}, playerMachine, "Hack a Home Network"));
    }
}
