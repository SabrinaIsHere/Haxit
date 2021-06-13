package com.company.Morticia.network;

import java.util.ArrayList;

/**
 * This class serves as a registry of all IP addresses, used for searching for a specific computer/address pair
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class IPRegistry {
    private static ArrayList<NetworkComponent> machines = new ArrayList<>();
    private static ArrayList<IPAddress> addresses = new ArrayList<>();

    /**
     * This method adds an entry which will then be discoverable
     *
     * @param machine The computer the IP corresponds with
     * @param address The address the computer corresponds with
     */
    public static void addEntry(NetworkComponent machine, IPAddress address) {
        machines.add(machine);
        addresses.add(address);
    }

    /**
     * Returns a computer as specified by the paired address
     *
     * @param address The address the computer corresponds with
     * @return Computer The computer which the address passed corresponds with
     */
    public static NetworkComponent getEntry(IPAddress address) {
        for (int i = 0; i < addresses.size(); i++) {
            if (addresses.get(i).ip.equals(address.ip)) {
                return machines.get(i);
            }
        }
        return null;
    }

    /**
     * This method determines and returns whether a specified IP is present in the registry
     *
     * @param address Address to be checked for
     * @return boolean Whether or not address is present
     */
    public static boolean hasEntry(IPAddress address) {
        for (IPAddress i : addresses) {
            if (i.ip.equals(address.ip)) {
                return true;
            }
        }
        return false;
    }
}
