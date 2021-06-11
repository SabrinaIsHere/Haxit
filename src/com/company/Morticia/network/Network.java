package com.company.Morticia.network;

import java.util.ArrayList;

public class Network {
    public ArrayList<NetworkComponent> connectedDevices;

    public Network() {
        connectedDevices = new ArrayList<>();
    }

    public boolean hasDevice(IPAddress deviceAddress) {
        for (NetworkComponent i : connectedDevices) {
            if (i.ip.equals(deviceAddress)) {
                return true;
            }
        }
        return false;
    }

    public NetworkComponent getDevice(IPAddress deviceAddress) {
        for (NetworkComponent i : connectedDevices) {
            if (i.ip.equals(deviceAddress)) {
                return i;
            }
        }
        return null;
    }
}
