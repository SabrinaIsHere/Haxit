package com.company.Morticia.computer.networkinterface;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.process.Process;
import com.company.Morticia.computer.process.defaultprocesses.DefaultNetworkingProcess;
import com.company.Morticia.network.*;

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

    /**
     * Initializes the default ports for a computer. Optional.
     *
     * Enables:
     *   Port 0 with protocol 1, for pinging
     */
    public void initDefaultPorts() {
        computer.processInterface.addProcess(new DefaultNetworkingProcess("DefaultNetworkingProcess", computer.processInterface.allocateID(), true, computer));
        ports.add(new Port(0, new int[]{1}));
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
        for (Process i : computer.processInterface.getProcesses()) {
            if (i.acceptsPort(packet.receiverPort)) {
                i.addPacket(packet);
            }
        }
    }
}
