package com.company.Morticia.network;

import com.company.Morticia.computer.Computer;

import java.util.ArrayList;

/**
 * This class serves as a registry of all IP addresses, used for searching for a specific computer/address pair
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class IPRegistry {
    private static ArrayList<Computer> computers = new ArrayList<>();
    private static ArrayList<IPAddress> addresses = new ArrayList<>();

    /**
     * This method adds an entry which will then be discoverable
     *
     * @param computer The computer the IP corresponds with
     * @param address The address the computer corresponds with
     */
    public static void addEntry(Computer computer, IPAddress address) {
        computers.add(computer);
        addresses.add(address);
    }

    /**
     * Returns a computer as specified by the paired address
     *
     * @param address The address the computer corresponds with
     * @return Computer The computer which the address passed corresponds with
     */
    public static Computer getEntry(IPAddress address) {
        for (int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).ip.equals(address.ip)) {
                return computers.get(i);
            }
        }
        return null;
    }
}
