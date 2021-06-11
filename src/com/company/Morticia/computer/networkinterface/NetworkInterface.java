package com.company.Morticia.computer.networkinterface;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.network.NetworkComponent;
import com.company.Morticia.network.Packet;

import java.util.Arrays;

public class NetworkInterface extends NetworkComponent {
    Computer computer;

    public NetworkInterface(Computer computer, NetworkInterface[] connectedDevices) {
        super();
        this.computer = computer;
        this.connectedDevices.addAll(Arrays.asList(connectedDevices));
    }

    public NetworkInterface(Computer computer, Computer[] connectedDevices) {
        super();
        this.computer = computer;
        for (Computer i : connectedDevices) {
            this.connectedDevices.add(i.networkInterface);
        }
    }

    public NetworkInterface(Computer computer) {
        super();
        this.computer = computer;
    }

    // 0 = execute command
    @Override
    public void handlePacket(Packet packet) {
        super.handlePacket(packet);
        if (portOpen(packet.receiverPort)) {
            if (packet.receiverPort == 0) {
                computer.addInput(packet.data);
            }
        }
    }
}
