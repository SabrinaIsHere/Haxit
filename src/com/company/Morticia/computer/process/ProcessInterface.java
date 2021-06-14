package com.company.Morticia.computer.process;

import java.util.ArrayList;

/**
 * This class serves as an interface between processes and the computer
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class ProcessInterface {
    ArrayList<Process> processes;

    /**
     * This initializes the processes list
     */
    public ProcessInterface() {
        this.processes = new ArrayList<>();
    }

    /**
     * This adds a process to be run
     *
     * @param process The process to be added
     */
    public void addProcess(Process process) {
        processes.add(process);
    }

    /**
     * Starts an existing process
     *
     * @param processID ID of the process to be added
     */
    public void startProcess(int processID) {
        for (Process i : processes) {
            if (i.processID == processID) {
                i.active = true;
                return;
            }
        }
    }

    /**
     * Stops an existing processing
     *
     * @param processID ID of process to be stopped
     */
    public void stopProcess(int processID) {
        for (Process i : processes) {
            if (i.processID == processID) {
                i.active = false;
                return;
            }
        }
    }

    /**
     * Gets the processes as an array
     *
     * @return Process[] Processes in array form
     */
    public Process[] getProcesses() {
        return processes.toArray(Process[]::new);
    }

    /**
     * Allocates an ID for a process to use
     *
     * @return int Allocated ID
     */
    public int allocateID() {
        return processes.size() - 1;
    }

    /**
     * Gets a process based on an ID and returns it
     *
     * @param id ID of the process to be returned
     * @return Process Process requested
     */
    public Process getProcess(int id) {
        return processes.get(id);
    }

    /**
     * This is called, code here is what will be run be the machine
     */
    public void tick() {
        for (Process i : processes) {
            while (i.hasDataToProcess()) {
                i.tick(this);
            }
        }
    }
}
