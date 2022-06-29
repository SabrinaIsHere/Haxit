package com.company.Morticia.network;

import com.company.Morticia.EntryPoint;
import com.company.Morticia.computer.process.ProcessInterface;
import com.company.Morticia.gui.terminal.TerminalIO;

public class DefaultNetworkComponentProcess extends NetworkProcess {
    /**
     * This constructor initializes internal lists and gets necessary data for the process
     *
     * @param processName      Name of the process
     * @param processID        The id of the process, used to identify it
     * @param active           Whether or not this process is active
     * @param networkComponent The Network Component this instance is attached to
     */
    public DefaultNetworkComponentProcess(String processName, int processID, boolean active, NetworkComponent networkComponent) {
        super(processName, processID, active, networkComponent);
    }

    @Override
    public void tick(NetworkProcessInterface processInterface) {
        super.tick(processInterface);

        if (!packetQueue.isEmpty()) {
            Packet packet = packetQueue.get(0);
            if (networkComponent.isPacketValid(packet, 1)) {
                if (packet.data.equals("1")) {
                    TerminalIO.println("Successfully pinged " + packet.senderIP.ip);
                } else {
                    if (IPRegistry.hasEntry(packet.senderIP)) {
                        IPRegistry.getEntry(packet.senderIP).handlePacket(new Packet(networkComponent.ip, packet.senderIP, 0, 0, 1, "1"));
                        EntryPoint.doubleTick = true;
                    }
                }
            }
            packetQueue.remove(0);
        }
    }
}
