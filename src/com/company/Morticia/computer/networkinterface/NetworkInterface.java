package com.company.Morticia.computer.networkinterface;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.network.IPAddress;
import com.company.Morticia.network.IPRegistry;
import com.company.Morticia.network.NetworkComponent;
import com.company.Morticia.network.Packet;

import java.util.Arrays;

/**
 * This class serves as an interface between the computer class and the many classes which make up networks.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class NetworkInterface extends NetworkComponent {
    Computer computer;

    /**
     * The constructor of this object takes several parameters in the service of instancing the object
     *
     * @param computer This is the computer which this object is attached to
     * @param connectedDevices This is the list of devices which this instance is directly connected with. In this constructor it is a list of type NetworkInterface.
     */
    public NetworkInterface(Computer computer, NetworkInterface[] connectedDevices) {
        super();
        this.computer = computer;
        this.connectedDevices.addAll(Arrays.asList(connectedDevices));
    }

    /**
     * This constructor is similar to the other, with the difference of the type of connectedDevices.
     *
     * @param computer The computer which this object is attached to
     * @param connectedDevices The list of computers which this is directly attached to
     */
    public NetworkInterface(Computer computer, Computer[] connectedDevices) {
        super();
        this.computer = computer;
        for (Computer i : connectedDevices) {
            this.connectedDevices.add(i.networkInterface);
        }
    }

    /**
     * This constructor is to be used in cases where this object is not directly connected with any other devices.
     *
     * @param computer The computer which this object is attached to
     */
    public NetworkInterface(Computer computer) {
        super();
        this.computer = computer;
    }

    // 0 = execute command

    /**
     * This method is called when a packet is received by this object. It handles the packet sent and it's corresponding data.
     *
     * @param packet The packet which has been received
     */
    @Override
    public void handlePacket(Packet packet) {
        super.handlePacket(packet);
        if (isPacketValid(packet, 0)) {
            computer.addInput(packet.data);
        } else if (isPacketValid(packet, 1)) {
            if (packet.data.equals("1")) {
                System.out.println("Successfully pinged " + packet.senderIP);
            } else {
                if (IPRegistry.hasEntry(packet.senderIP)) {
                    IPRegistry.getEntry(packet.senderIP).networkInterface.handlePacket(new Packet(computer, packet.senderIP, 0, 0, 1, "1"));
                }
            }
        }
    }
}
