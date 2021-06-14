package com.company.Morticia.network;

import com.company.Morticia.computer.Computer;
import com.company.Morticia.computer.process.ProcessInterface;
import com.company.Morticia.network.NetworkComponent;
import com.company.Morticia.network.Packet;
import com.company.Morticia.network.Port;

import java.util.ArrayList;

/**
 * This class serves as a way to dynamically change the behavior of a computer when tick() is called. You can make a process, add it to a machine, and it will be called on every tick. You can also handle networking with it by directing any traffic from a number of ports to the process.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/14/21
 */
public class NetworkProcess {
    String processName;
    int processID;
    boolean active;
    public NetworkComponent networkComponent;
    public ArrayList<Packet> packetQueue;
    public ArrayList<String> dataQueue;
    public ArrayList<Port> ports;

    /**
     * This constructor initializes internal lists and gets necessary data for the process
     *
     * @param processName Name of the process
     * @param processID The id of the process, used to identify it
     * @param active Whether or not this process is active
     * @param networkComponent The Network Component this instance is attached to
     */
    public NetworkProcess(String processName, int processID, boolean active, NetworkComponent networkComponent) {
        this.processName = processName;
        this.processID = processID;
        this.active = active;
        this.networkComponent = networkComponent;
        this.packetQueue = new ArrayList<>();
        this.dataQueue = new ArrayList<>();
        this.ports = new ArrayList<>();
    }

    /**
     * This method toggles whether active is on or off, i.e. if active is on when it's called it will be turned off
     *
     * @return Current state of active
     */
    public boolean toggleActive() {
        active = !active;
        return active;
    }

    /**
     * Adds a packet to the queue to bee processed
     *
     * @param packet Packet to be added to queue
     */
    public void addPacket(Packet packet) {
        packetQueue.add(packet);
    }

    /**
     * Adds data to queue to be processed. Mostly intended for inter process communication
     *
     * @param data Data to be added
     */
    public void addData(String data) {
        dataQueue.add(data);
    }

    /**
     * Used to determine whether there's still packets or other input to process by the ProcessInterface
     *
     * @return Whether or not there's still data needing to be processed
     */
    public boolean hasDataToProcess() {
        return !packetQueue.isEmpty() || !dataQueue.isEmpty();
    }

    public boolean acceptsPort(int port) {
        for (Port i : ports) {
            if (i.portNumber == port) {
                return true;
            }
        }
        return false;
    }

    /**
     * Called by computer this is attached to. Any code which is supposed to run throughout the game should be entered in an over ride of this method
     *
     * @param networkProcessInterface The process interface calling this. Allows for inter process communication
     */
    public void tick(NetworkProcessInterface networkProcessInterface) {

    }
}
