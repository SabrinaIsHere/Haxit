package com.company.Morticia.network;

import com.company.Morticia.computer.Computer;

public class Packet {
    public IPAddress receiverIP;
    public IPAddress senderIP;
    public int receiverPort;
    public int senderPort;
    public String data;

    public Packet(Computer sender, IPAddress receiverIP, int receiverPort, int senderPort, String data) {
        this.receiverIP = receiverIP;
        this.senderIP = sender.networkInterface.ip;
        this.receiverPort = receiverPort;
        this.senderPort = senderPort;
        this.data = data;
    }

    public Packet(IPAddress senderIP, IPAddress receiverIP, int receiverPort, int senderPort, String data) {
        this.receiverIP = receiverIP;
        this.senderIP = senderIP;
        this.receiverPort = receiverPort;
        this.senderPort = senderPort;
        this.data = data;
    }
}
