package com.company.Morticia.network;

import java.util.ArrayList;

public class NetworkComponent {
    public IPAddress ip;
    public ArrayList<NetworkComponent> connectedDevices;
    public boolean acceptingTraffic;
    public ArrayList<Integer> openPorts;
    public Network network;

    public NetworkComponent() {
        this.ip = new IPAddress();
        this.connectedDevices = new ArrayList<>();
        this.acceptingTraffic = true;
    }

    public boolean portOpen(int port) {
        for (Integer i : openPorts) {
            if (i == port) {
                return true;
            }
        }
        return false;
    }

    // Override this in things that extend this class
    public void handlePacket(Packet packet) {

    }
}
