package com.company.Morticia.computer.filesystem;

import com.company.Morticia.computer.terminal.commands.Command;

import java.util.ArrayList;

// T is the type of data it stores, so you can have integers or strings or commands stored in the file

/**
 * This class is meant to store data in a way which is accessible and editable inside the game itself. Files can be executed if T is of type 'Command'
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 *
 * @param <T> The type of data to be stored by this file
 */
public class File<T> {
    public String fileName;
    public String extension;
    public Folder parent;

    public ArrayList<T> data;

    /**
     * This constructor initializes the members of this object.
     *
     * @param fileName The name of the file being created
     * @param extension The extension of the file, i.e. .txt or .exe
     * @param parent The folder which this file resides within
     */
    public File(String fileName, String extension, Folder parent) {
        data = new ArrayList<>();
        this.fileName = fileName;
        this.extension = extension;
        this.parent = parent;
    }

    /**
     * This method converts the member variables of this file into a single string for easy conversion to a format which can be saved to a disk.
     *
     * @return The list of string version of data, in the order of: File (header so you know what the type is), name: , extension: , and ensuing data held within the file
     */
    public ArrayList<String> serialize() {
        ArrayList<String> tempData = new ArrayList<>();

        tempData.add("File");
        tempData.add("name: " + fileName);
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
