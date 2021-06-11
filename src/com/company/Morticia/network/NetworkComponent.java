package com.company.Morticia.network;

import java.util.ArrayList;

public class NetworkComponent {
    public IPAddress ip;
    public ArrayList<NetworkComponent> connectedDevices;
    public boolean acceptingTraffic;
    public ArrayList<Port> ports;
    public Network network;

    public NetworkComponent() {
        this.ip = new IPAddress();
        this.connectedDevices = new ArrayList<>();
        this.acceptingTraffic = true;
    }

    public boolean portOpen(int port) {
        for (Port i : ports) {
            if (i.portNumber == port) {
                return i.open;
            }
        }
        return false;
    }

    public Port getPort(int portNumber) {
        for (Port i : ports) {
            if (i.portNumber == portNumber) {
                return i;
            }
        }
        return null;
    }

    public boolean isPacketValid(Packet packet, int protocol) {
        return portOpen(packet.receiverPort) && packet.protocol == protocol && getPort(packet.receiverPort).acceptsProtocol(protocol);
    }

    // Override this in things that extend this class
    public void handlePacket(Packet packet) {

    }
}
