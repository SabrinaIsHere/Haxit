package com.company.Morticia.computer.filesystem;

public class Filesystem {
    public Folder root;

    public Filesystem(boolean initializeDefaultFiles) {
        root = new Folder();

        if (initializeDefaultFiles) {
            root.addFolder(new Folder(root, "bin"));
            root.addFolder(new Folder(root, "Home"));
        }
    }

    public int copyFile(FilePath file1, FilePath file2) {
        file1.path.set(file1.path.size() - 1, file2.path.get(file2.path.size() - 1));
        return 1;
    }

    public int deleteFolder(FilePath folder) {
        folder.path.get(folder.path.size() - 1).parent.childFolders.remove(folder.path.get(folder.path.size() - 1));
        return 1;
    }

    public int deleteFile(FilePath file) {
        file.path.get(file.path.size() - 1).parent.childFolders.remove(file.path.get(file.path.size() - 1));
        return 1;
    }
}
