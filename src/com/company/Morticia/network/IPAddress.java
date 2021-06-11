package com.company.Morticia.network;

import java.util.ArrayList;
import java.util.Objects;

public class IPAddress {
    public static ArrayList<String> ipRegistry = new ArrayList<>();

    public final int section1;
    public final int section2;
    public final int section3;
    public final int section4;
    public final String ip;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IPAddress ipAddress = (IPAddress) o;
        return section1 == ipAddress.section1 && section2 == ipAddress.section2 && section3 == ipAddress.section3 && section4 == ipAddress.section4 && ip.equals(ipAddress.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section1, section2, section3, section4, ip);
    }
}
