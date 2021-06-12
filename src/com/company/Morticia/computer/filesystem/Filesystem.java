package com.company.Morticia.computer.filesystem;

/**
 * This class is used by the computer to interface with files and folders.
 *
 * @author Morticia
 * @version 1.0
 * @since 6/12/21
 */
public class Filesystem {
    public Folder root;
    public Folder currFolder;

    /**
     * This constructor initializes root and optionally some standard folders
     *
     * @param initializeDefaultFiles Whether or not default files should be added to the filesystem
     */
    public Filesystem(boolean initializeDefaultFiles) {
        root = new Folder();
        currFolder = root;

        if (initializeDefaultFiles) {
            root.addFolder(new Folder(root, "bin"));
            root.addFolder(new Folder(root, "Home"));
        }
    }

    /**
     * This method copies a file from one path and into another
     *
     * @param file1 The file to copy from
     * @param file2 The place to copy to
     * @return int Error code. 1 if functions correctly
     */
    public int copyFile(FilePath file1, FilePath file2) {
        file1.path.set(file1.path.size() - 1, file2.path.get(file2.path.size() - 1));
        return 1;
    }

    /**
     * Deletes a folder from the filesystem
     *
     * @param folder The path to the folder which is to be deleted
     * @return int Error code
     */
    public int deleteFolder(FilePath folder) {
        folder.path.get(folder.path.size() - 1).parent.childFolders.remove(folder.path.get(folder.path.size() - 1));
        return 1;
    }

    /**
     * Deletes a file from the filesystem
     *
     * @param file The path to the file to be deleted
     * @return int Error code
     */
    public int deleteFile(FilePath file) {
        file.path.get(file.path.size() - 1).parent.childFolders.remove(file.path.get(file.path.size() - 1));
        return 1;
    }
}
