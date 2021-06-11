package com.company.Morticia.network;

public class Port {
    public int portNumber;
    public int []acceptedProtocols;
    public boolean open;

    public Port(int portNumber, int[] acceptedProtocols) {
        this.portNumber = portNumber;
        this.acceptedProtocols = acceptedProtocols;
        this.open = true;
    }

    public boolean toggleOpen() {
        this.open = !open;
        return open;
    }

    public boolean acceptsProtocol(int protocol) {
        for (int i : acceptedProtocols) {
            if (i == protocol) {
                return true;
            }
        }
        return false;
    }
}
