package com.company.Morticia.computer.filesystem;

public class Filesystem {
    Folder root;

    public Filesystem(boolean initializeDefaultFiles) {
        root = new Folder();

        if (initializeDefaultFiles) {
            root.addFolder(new Folder(root, "bin"));
            root.addFolder(new Folder(root, "Home"));
        }
    }

    public int loadFromDisk() {
        return 1;
    }

    public int saveToDisk() {
        return 1;
    }

    public int copyFile() {
        return 1;
    }

    public int deleteFile() {
        return 1;
    }

    public int makeFolder() {
        return 1;
    }

    public int makeFile() {
        return 1;
    }
}
