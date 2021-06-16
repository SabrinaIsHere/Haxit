package com.company.Morticia.network;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.networkinterface.NetworkInterface;

/**
 * This class serves to hold data which is transmitted between computers or networked machines
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Packet {
    public IPAddress receiverIP;
    public IPAddress senderIP;
    public int receiverPort;
    public int senderPort;
    public int protocol;
    public String data;

    /**
     * This constructor initializes the Packet object
     *
     * @param sender The machine which sent this packet
     * @param receiverIP The ip of the machine which is receiving this packet
     * @param receiverPort The port his packet is being to
     * @param senderPort The port this is being sent from
     * @param protocol The protocol this packet engages with; determines how data is handled
     * @param data The data this packet transmits
     */
    public Packet(Computer sender, IPAddress receiverIP, int receiverPort, int senderPort, int protocol, String data) {
        this.receiverIP = receiverIP;
        this.senderIP = sender.networkInterface.ip;
        this.receiverPort = receiverPort;
        this.senderPort = senderPort;
        this.protocol = protocol;
        this.data = data;
    }

    /**
     *
     * @param senderIP The ip of the machine which sent this packet
     * @param receiverIP The ip of the machine which is receiving this packet
     * @param receiverPort The port his packet is being to
     * @param senderPort The port this is being sent from
     * @param protocol The protocol this packet engages with; determines how data is handled
     * @param data The data this packet transmits
     */
    public Packet(IPAddress senderIP, IPAddress receiverIP, int receiverPort, int senderPort, int protocol, String data) {
        this.receiverIP = receiverIP;
        this.senderIP = senderIP;
        this.receiverPort = receiverPort;
        this.senderPort = senderPort;
        this.protocol = protocol;
        this.data = data;
    }

    /**
     * This method is used to send this packet to the ip address specified when this object was instanced
     */
    public void send() {
        if (IPRegistry.hasEntry(this.receiverIP)) {
            NetworkComponent machine = IPRegistry.getEntry(this.receiverIP);
            machine.handlePacket(this);
        }
    }
}
