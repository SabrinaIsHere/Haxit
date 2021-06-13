package com.company.Morticia.network;

/**
 * This class serves to house data about a specific port on a machine
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Port {
    public int portNumber;
    public int []acceptedProtocols;
    public boolean open;

    /**
     * This constructor initializes the class members
     *
     * @param portNumber This is the number, or ID, this object corresponds with
     * @param acceptedProtocols These are the protocols which traffic will be able to carry when interacting with this port
     */
    public Port(int portNumber, int[] acceptedProtocols) {
        this.portNumber = portNumber;
        this.acceptedProtocols = acceptedProtocols;
        this.open = true;
    }

    /**
     * This method toggles whether this port is open or not, i.e. if it was off calling this will turn it on
     *
     * @return boolean Whether port is now on or off
     */
    public boolean toggleOpen() {
        this.open = !open;
        return open;
    }

    /**
     * Determines whether the entered protocol is accepted or not
     *
     * @param protocol The protocol to be checked
     * @return boolean Whether or not the protocol will be accepted
     */
    public boolean acceptsProtocol(int protocol) {
        for (int i : acceptedProtocols) {
            if (i == protocol) {
                return true;
            }
        }
        return false;
    }

    /**
     * Converts the accepted protocols into a human readable string
     *
     * @return String Protocols which are accepted in string form
     */
    public String protocolsToString() {
        StringBuilder buffer = new StringBuilder();
        for (int i : acceptedProtocols) {
            if (i != acceptedProtocols[acceptedProtocols.length - 1]) {
                buffer.append(i).append(", ");
            } else {
                buffer.append(i);
            }
        }
        return buffer.toString();
    }
}
