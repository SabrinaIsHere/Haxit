package com.company.Morticia.computer.filesystem;

import com.company.Morticia.computer.terminal.commands.Command;

import java.util.ArrayList;

// T is the type of data it stores, so you can have integers or strings or commands stored in the file
public class File<T> {
    public String name;
    public String extension;

    public ArrayList<T> data;

    public File(String name, String extension) {
        data = new ArrayList<>();
        this.name = name;
        this.extension = extension;
    }

    public ArrayList<String> serialize() {
        ArrayList<String> tempData = new ArrayList<>();

        tempData.add("File");
        tempData.add("name: " + name);
        tempData.add("extension: " + extension);

        if (!data.isEmpty()) {
            for (T i : data) {
                if (i.getClass().equals(String.class)) {
                    tempData.add((String) i);
                } else if (i.getClass().equals(int.class)) {
                    tempData.add((String) i);
                } else if (i.getClass().equals(boolean.class)) {
                    if ((boolean) i) {
                        tempData.add("1");
                    } else {
                        tempData.add("0");
                    }
                } else if (i.getClass().equals(Command.class)) {
                    tempData.add(i.toString());
                } else {
                    System.out.println("Type not supported for serialization, stopping.");
                    return null;
                }
            }
        }
        return tempData;
    }
}
