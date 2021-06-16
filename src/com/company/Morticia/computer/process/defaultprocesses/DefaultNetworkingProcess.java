package com.company.Morticia.computer.process.defaultprocesses;

import com.company.Morticia.EntryPoint;
import com.company.Morticia.network.*;

public class DefaultNetworkingProcess extends NetworkProcess {
    /**
     * This constructor initializes internal lists and gets necessary data for the process
     *
     * @param processName Name of the process
     * @param processID   The id of the process, used to identify it
     * @param active      Whether or not this process is active
     * @param machine    The machine this instance is attached to
     */
    public DefaultNetworkingProcess(String processName, int processID, boolean active, NetworkComponent machine) {
        super(processName, processID, active, machine);
        this.ports.add(new Port(0, new int[]{1, 2}));
    }

    @Override
    public void tick(NetworkProcessInterface processInterface) {
        if (!packetQueue.isEmpty()) {
            Packet packet = packetQueue.get(0);
            if (this.networkComponent.isPacketValid(packet, 1)) {
                if (packet.data.equals("1")) {
                    System.out.println("Successfully pinged " + packet.senderIP.ip);
                } else {
                    if (IPRegistry.hasEntry(packet.senderIP)) {
                        IPRegistry.getEntry(packet.senderIP).handlePacket(new Packet(networkComponent.ip, packet.senderIP, 0, 0, 1, "1"));
                        EntryPoint.doubleTick = true;
                    }
                }
            } else if (networkComponent.isPacketValid(packet, 2)) {
                System.out.println(packet.data);
                EntryPoint.doubleTick = true;
            }
            packetQueue.remove(0);
        }
    }
}
