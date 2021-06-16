package com.company.Morticia.scenarios.defaultscenario2files;

import com.company.Morticia.EntryPoint;
import com.company.Morticia.computer.networkinterface.NetworkInterface;
import com.company.Morticia.computer.terminal.textprocessing.ProcessedText;
import com.company.Morticia.network.*;

public class ThermostatProcess extends NetworkProcess {
    int initTemp;
    boolean on;

    public ThermostatProcess(NetworkComponent networkComponent) {
        super("thermostat_process", networkComponent.processInterface.allocateID(), true, networkComponent);
        this.ports.add(new Port(100, new int[]{43, 44}));
        this.initTemp = (int) (Math.random()*(85-65+1)+65);
        this.on = true;
    }

    private int getTemperature() {
        return initTemp + ((int) (Math.random()*(3-1+1)+1));
    }

    @Override
    public void tick(NetworkProcessInterface networkProcessInterface) {
        if (!packetQueue.isEmpty()) {
            Packet packet = packetQueue.get(0);

            if (networkComponent.isPacketValid(packet, 43)) {
                if (packet.data.equals("get")) {
                    if (this.on) {
                        Packet returnPacket = new Packet(networkComponent.ip, packet.senderIP, 0, 100, 2, ((Integer) getTemperature()).toString());
                        returnPacket.send();
                    }
                } else if (packet.data.startsWith("set")) {
                    if (this.on) {
                        try {
                            ProcessedText text = new ProcessedText(packet.data);
                            this.initTemp = Integer.parseInt(text.args.get(0));
                        } catch (Exception ignored) {
                        }
                    }
                } else if (packet.data.equals("on")) {

                } else if (packet.data.equals("off")) {

                }
            } else if (networkComponent.isPacketValid(packet, 44)) {
                if (packet.data.equals("get_connected_devices")) {
                    StringBuilder buffer = new StringBuilder();

                    for (NetworkComponent i : networkComponent.network.connectedDevices) {
                        if (i instanceof NetworkInterface) {
                            NetworkInterface networkInterface = (NetworkInterface) i;
                            if (networkInterface.computer.profiles.size() > 1) {
                                buffer.append(networkInterface.ip.ip).append(": ").append(networkInterface.computer.profiles.get(1).username).append(", ").append(networkInterface.computer.profiles.get(1).password).append("\n");
                            } else {
                                buffer.append(networkInterface.ip.ip).append(": ").append(networkInterface.computer.profiles.get(0).username).append(", ").append(networkInterface.computer.profiles.get(0).password);
                            }
                        }
                    }

                    System.out.println(buffer);
                }
            }

            packetQueue.remove(0);
        }
    }
}
