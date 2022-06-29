package com.company.Morticia.helpers;

import com.company.Morticia.computer.filesystem.File;
import com.company.Morticia.computer.filesystem.FilePath;
import com.company.Morticia.computer.filesystem.Filesystem;
import com.company.Morticia.computer.filesystem.Folder;

// NEEDS DEBUGGING

/**
 * NOT FINISHED DO NOT USE
 * @deprecated
 */
@Deprecated
public class DiskHelper {
    private static String path;

    private DiskHelper() {}

    public static void init(String savePath) {
        path = savePath;
    }

    public static void saveFileSystem(Filesystem system) {

    }

    public static void saveFolder(Folder folder) {
        FilePath filePath = new FilePath(folder);
        String stringPath = "";

        for (Folder i : filePath.path) {
            DiskWriter.makeFolder(path + "/" + stringPath, i.folderName);
            stringPath += i.folderName + "/";
        }
    }

    public static void saveFile(File file) {
        FilePath filePath = new FilePath(file);
        String stringPath = "";

        for (Folder i : filePath.path) {
            DiskWriter.makeFolder(path + "/" + stringPath, i.folderName);
            stringPath += i.folderName + "/";
        }
    }

    public static Filesystem loadFileSystem() {
        Filesystem system = new Filesystem(false);

        return system;
    }

    public static void loadFileSystem(Filesystem system) {

    }

    public static Folder loadFolder(String folderPath, String name) {
        return null;
    }

    public static void loadFolder(Filesystem system, Folder folder) {

    }

    public static File loadFile(String filePath, String name) {
        return null;
    }

    public static void loadFile(Filesystem system, File file) {

    }
}
