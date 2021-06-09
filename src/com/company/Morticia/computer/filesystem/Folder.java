package com.company.Morticia.computer.filesystem;

import java.util.ArrayList;
import java.util.Vector;

public class Folder {
    Folder parent;
    Vector<Folder> childFolders;
    Vector<File> childFiles;

    public String folderName;
    boolean isRoot;

    public Folder(Folder parent, String name) {
        this.parent = parent;
        this.folderName = name;
        this.isRoot = false;
    }

    // This should only be to initialize root
    public Folder() {
        this.folderName = "";
        this.isRoot = true;
    }

    @Override
    public String toString() {
        return "Folder: name: " + folderName + "," + "parent folder name: " + parent.folderName;
    }

    public void addFolder(Folder folder) {
        childFolders.add(folder);
    }

    public void addFile(File file) {
        childFiles.add(file);
    }

    public Folder removeFolder(String folderName) {
        for (int i = 0; i < childFolders.size(); i++) {
            if (childFolders.get(i).folderName.equals(folderName)) {
                return childFolders.remove(i);
            }
        }
        return null;
    }

    public File removeFile(String fileName) {
        for (int i = 0; i < childFiles.size(); i++) {
            if (childFiles.get(i).name.equals(fileName)) {
                return childFiles.remove(i);
            }
        }
        return null;
    }

    public Folder removeFolder(int index) {
        return childFolders.remove(index);
    }

    public File removeFile(int index) {
        return childFiles.remove(index);
    }

    public boolean hasFolder(String folderName) {
        for (Folder i : childFolders) {
            if (i.folderName.equals(folderName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFile(String fileName) {
        for (File i : childFiles) {
            if (i.name.equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public Folder getFolder(String folderName) {
        for (Folder i : childFolders) {
            if (i.folderName.equals(folderName)) {
                return i;
            }
        }
        return null;
    }

    public File getFile(String fileName) {
        for (File i : childFiles) {
            if (i.name.equals(fileName)) {
                return i;
            }
        }
        return null;
    }

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
