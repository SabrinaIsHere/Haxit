package com.company.Morticia.computer.filesystem;

import java.util.ArrayList;

/**
 * This class serves as a folder in which other folders and files can be added
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Folder {
    public Folder parent;
    public ArrayList<Folder> childFolders;
    public ArrayList<File> childFiles;

    public String folderName;
    boolean isRoot;

    /**
     * This constructor initializes the member variables of this object
     *
     * @param parent The folder this is a child of
     * @param name The name of this folder
     */
    public Folder(Folder parent, String name) {
        this.parent = parent;
        this.folderName = name;
        this.isRoot = false;

        this.childFolders = new ArrayList<>();
        this.childFiles = new ArrayList<>();
    }

    /**
     * This constructor should only be used to initialize the root of the filesystem
     */
    public Folder() {
        this.folderName = "";
        this.isRoot = true;

        this.childFolders = new ArrayList<>();
        this.childFiles = new ArrayList<>();
    }

    /**
     * This method is used to convert this object into a human readable string
     *
     * @return String The human readable version of this object
     */
    @Override
    public String toString() {
        return "Folder: name: " + folderName + "," + "parent folder name: " + parent.folderName;
    }

    /**
     * Adds a specified folder as a child of this folder
     *
     * @param folder Folder to be added as a child
     */
    public void addFolder(Folder folder) {
        childFolders.add(folder);
    }

    /**
     * Adds a file to this folder as a child
     *
     * @param file File to be added to this folder
     */
    public void addFile(File file) {
        childFiles.add(file);
    }

    /**
     * Removes a folder from this folder
     *
     * @param folderName Name of the folder to be removed
     * @return Folder Folder that was removed
     */
    public Folder removeFolder(String folderName) {
        for (int i = 0; i < childFolders.size(); i++) {
            if (childFolders.get(i).folderName.equals(folderName)) {
                return childFolders.remove(i);
            }
        }
        return null;
    }

    /**
     * Removes a file from this folder
     *
     * @param fileName Name of the file to be removed
     * @return File File that was removed
     */
    public File removeFile(String fileName) {
        for (int i = 0; i < childFiles.size(); i++) {
            if (childFiles.get(i).fileName.equals(fileName)) {
                return childFiles.remove(i);
            }
        }
        return null;
    }

    /**
     * Removes a child folder from this folder
     *
     * @param index Index in the list of children you want to remove
     * @return Folder Folder that was removed
     */
    public Folder removeFolder(int index) {
        return childFolders.remove(index);
    }

    /**
     * Removes a child file from this folder
     *
     * @param index Index in the list of children you to remove
     * @return File File that was removed
     */
    public File removeFile(int index) {
        return childFiles.remove(index);
    }

    /**
     * Checks if this object has the folder specified as a child
     *
     * @param folderName Name of the folder to be searched for
     * @return boolean Whether for not the folder is present
     */
    public boolean hasFolder(String folderName) {
        for (Folder i : childFolders) {
            if (i.folderName.equals(folderName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this object has the file specified as a child
     *
     * @param fileName Name of the file to be searched for
     * @return boolean Whether for not the file is present
     */
    public boolean hasFile(String fileName) {
        for (File i : childFiles) {
            if (i.fileName.equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the folder of specified name
     *
     * @param folderName Name of the folder to be searched for
     * @return Folder First folder with name specified
     */
    public Folder getFolder(String folderName) {
        for (Folder i : childFolders) {
            if (i.folderName.equals(folderName)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Gets the file of specified name
     *
     * @param fileName Name of the folder to be searched for
     * @return File First file with name specified
     */
    public File getFile(String fileName) {
        for (File i : childFiles) {
            if (i.fileName.equals(fileName)) {
                return i;
            }
        }
        return null;
    }

    /**
     * This method converts this object into a human readable string
     *
     * @return String Human readable version of this object
     */
    public ArrayList<String> serialize() {
        ArrayList<String> tempData = new ArrayList<>();

        tempData.add("Folder");

        tempData.add("name: " + folderName);
        tempData.add("parent: " + parent);

        tempData.add("-- Child Folders");

        for (Folder i : childFolders) {
            tempData.add(i.toString());
        }

        tempData.add("-- Child Files");

        for (File i : childFiles) {
            tempData.add(i.toString());
        }

        return tempData;
    }
}
