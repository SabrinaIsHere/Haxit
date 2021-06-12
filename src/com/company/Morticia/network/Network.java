package com.company.Morticia.network;

import java.util.ArrayList;

/**
 * This class is more or less optional, you can use it to organize networked machines but you could also just connect them manually.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Network {
    public ArrayList<NetworkComponent> connectedDevices;

    /**
     * This constructor initializes the list of devices this network connects with
     */
    public Network() {
        connectedDevices = new ArrayList<>();
    }

    /**
     * This method detects whether a specified device is present on this network
     *
     * @param deviceAddress Address of the device you are searching
     * @return boolean Whether or not the address is present
     */
    public boolean hasDevice(IPAddress deviceAddress) {
        for (NetworkComponent i : connectedDevices) {
            if (i.ip.equals(deviceAddress)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets a connected device as specified by the provided address
     *
     * @param deviceAddress Address of the device which is being fetched
     * @return NetworkComponent The device which is to be fetched; null if device is not present
     */
    public NetworkComponent getDevice(IPAddress deviceAddress) {
        for (NetworkComponent i : connectedDevices) {
            if (i.ip.equals(deviceAddress)) {
                return i;
            }
        }
        return null;
    }
}
