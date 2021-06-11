package com.company.Morticia.network;

import com.company.Morticia.computer.Computer;

import java.util.ArrayList;

public class IPRegistry {
    private static ArrayList<Computer> computers = new ArrayList<>();
    private static ArrayList<IPAddress> addresses = new ArrayList<>();

    public static void addEntry(Computer computer, IPAddress address) {
        computers.add(computer);
        addresses.add(address);
    }

    public static Computer getEntry(IPAddress address) {
        for (int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).ip.equals(address.ip)) {
                return computers.get(i);
            }
        }
        return null;
    }
}
