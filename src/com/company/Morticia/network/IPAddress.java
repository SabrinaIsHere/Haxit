package com.company.Morticia.network;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * This class provides an automatically generated unique IP addresses to network enabled devices
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class IPAddress {
    public static ArrayList<String> ipRegistry = new ArrayList<>();

    public final int section1;
    public final int section2;
    public final int section3;
    public final int section4;
    public final String ip;

    /**
     * This constructor generates four unique random sequences of numbers and a string which can be accessed at any time
     */
    public IPAddress() {
        int temp1 = (int) (Math.random()*(999-1+1)+1);
        int temp2 = (int) (Math.random()*(999-1+1)+1);
        int temp3 = (int) (Math.random()*(999-1+1)+1);
        int temp4 = (int) (Math.random()*(999-1+1)+1);
        String tempIp = temp1 + "." + temp2 + "." + temp3 + "." + temp4;
        while (true) {
            if (ipRegistry.contains(tempIp)) {
                temp1 = (int) (Math.random()*(999-1+1)+1);
                temp2 = (int) (Math.random()*(999-1+1)+1);
                temp3 = (int) (Math.random()*(999-1+1)+1);
                temp4 = (int) (Math.random()*(999-1+1)+1);
                tempIp = temp1 + "." + temp2 + "." + temp3 + "." + temp4;
            } else {
                section1 = temp1;
                section2 = temp2;
                section3 = temp3;
                section4 = temp4;
                ip = tempIp;
                ipRegistry.add(ip);
                return;
            }
        }
    }

    /**
     * This constructor generates and IPAddress object from a string, these will not be checked for conflicts with other IPs so use with caution.
     *
     * @param address The address to be converted into an object
     */
    public IPAddress(String address) {
        String []sections = address.split(Pattern.quote("."));
        ip = address;
        section1 = Integer.parseInt(sections[0]);
        section2 = Integer.parseInt(sections[1]);
        section3 = Integer.parseInt(sections[2]);
        section4 = Integer.parseInt(sections[3]);
    }

    /**
     * This method evaluates whether this IP is equal to another
     *
     * @param o Object to be compared with
     * @return boolean Whether or no they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IPAddress ipAddress = (IPAddress) o;
        return section1 == ipAddress.section1 && section2 == ipAddress.section2 && section3 == ipAddress.section3 && section4 == ipAddress.section4 && ip.equals(ipAddress.ip);
    }
}
