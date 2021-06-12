package com.company.Morticia.network;

import java.util.ArrayList;

/**
 * This class is to be extended by all networking enabled devices. It provides functionality for interaction between devices
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class NetworkComponent {
    public IPAddress ip;
    public ArrayList<NetworkComponent> connectedDevices;
    public boolean acceptingTraffic;
    public ArrayList<Port> ports;
    public Network network;

    /**
     * Assigns unique random IP address and initializes other class members
     */
    public NetworkComponent() {
        this.ip = new IPAddress();
        this.connectedDevices = new ArrayList<>();
        this.acceptingTraffic = true;
    }

    /**
     * Detects whether a specified port is open or not
     *
     * @param port The port which is to be checked
     * @return boolean Whether or not the specified port is open
     */
    public boolean portOpen(int port) {
        for (Port i : ports) {
            if (i.portNumber == port) {
                return i.open;
            }
        }
        return false;
    }

    /**
     * Returns the specified port object based on the number provided
     *
     * @param portNumber The number, or id, of the port which is to be returned
     * @return Port Port which is to be returned
     */
    public Port getPort(int portNumber) {
        for (Port i : ports) {
            if (i.portNumber == portNumber) {
                return i;
            }
        }
        return null;
    }

    /**
     * This method checks whether a packet is valid for a specified protocol
     *
     * @param packet Packet to be checked
     * @param protocol Protocol for packet to be checked against
     * @return boolean Whether or not the packet is valid
     */
    public boolean isPacketValid(Packet packet, int protocol) {
        return portOpen(packet.receiverPort) && packet.protocol == protocol && getPort(packet.receiverPort).acceptsProtocol(protocol);
    }

    /**
     * This method is to be overridden in classes which extend this one. This will be called when a packet is received
     *
     * @param packet Packet which has been received by this device
     */
    public void handlePacket(Packet packet) {

    }
}
