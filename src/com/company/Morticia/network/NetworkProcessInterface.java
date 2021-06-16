package com.company.Morticia.network;

import com.company.Morticia.computer.process.Process;

import java.util.ArrayList;

/**
 * This class is a network specified variant of the process interface used in the computer class
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class NetworkProcessInterface {
    public ArrayList<NetworkProcess> processes;

    /**
     * Initializes the processes list
     */
    public NetworkProcessInterface() {
        this.processes = new ArrayList<>();
    }

    /**
     * Adds a process to be run
     *
     * @param process Process to be added
     */
    public void addProcess(NetworkProcess process) {
        processes.add(process);
    }

    /**
     * Starts a process which already exists
     *
     * @param processID Process to be started
     */
    public void startProcess(int processID) {
        for (NetworkProcess i : processes) {
            if (i.processID == processID) {
                i.active = true;
                return;
            }
        }
    }

    /**
     * Stops an existing process
     *
     * @param processID Process to be started
     */
    public void stopProcess(int processID) {
        for (NetworkProcess i : processes) {
            if (i.processID == processID) {
                i.active = false;
                return;
            }
        }
    }

    /**
     * Gets an available ID and returns it
     *
     * @return int Available ID
     */
    public int allocateID() {
        return processes.size() - 1;
    }

    /**
     * Gets a process based on it's id
     *
     * @param id Id of process to be gotten
     * @return NetworkProcess The process requested
     */
    public NetworkProcess getProcess(int id) {
        return processes.get(id);
    }

    /**
     * Called to run this process
     */
    public void tick() {
        for (NetworkProcess i : processes) {
            while (i.hasDataToProcess()) {
                i.tick(this);
            }
        }
    }
}