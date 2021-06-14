package com.company.Morticia.computer.process.defaultprocesses;

import com.company.Morticia.EntryPoint;
import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.process.Process;
import com.company.Morticia.computer.process.ProcessInterface;
import com.company.Morticia.network.IPRegistry;
import com.company.Morticia.network.Packet;
import com.company.Morticia.network.Port;

public class DefaultNetworkingProcess extends Process {
    /**
     * This constructor initializes internal lists and gets necessary data for the process
     *
     * @param processName Name of the process
     * @param processID   The id of the process, used to identify it
     * @param active      Whether or not this process is active
     * @param computer    The computer this instance is attached to
     */
    public DefaultNetworkingProcess(String processName, int processID, boolean active, Computer computer) {
        super(processName, processID, active, computer);
        this.ports.add(new Port(0, new int[]{1}));
    }

    @Override
    public void tick(ProcessInterface processInterface) {
        super.tick(processInterface);

        if (!packetQueue.isEmpty()) {
            Packet packet = packetQueue.get(0);

            if (computer.networkInterface.isPacketValid(packet, 0)) {
                System.out.println("1");
                computer.addInput(packet.data);
            } else if (computer.networkInterface.isPacketValid(packet, 1)) {
                if (packet.data.equals("1")) {
                    System.out.println("Successfully pinged " + packet.senderIP.ip);
                } else {
                    if (IPRegistry.hasEntry(packet.senderIP)) {
                        IPRegistry.getEntry(packet.senderIP).handlePacket(new Packet(computer, packet.senderIP, 0, 0, 1, "1"));
                        EntryPoint.doubleTick = true;
                    }
                }
            }
            packetQueue.remove(0);
        }
    }
}
