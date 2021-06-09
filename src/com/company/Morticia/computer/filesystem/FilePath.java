 package com.company.Morticia.computer.filesystem;

import java.util.ArrayList;

public class FilePath {
    public ArrayList<Folder> path;
    public File file;

    public FilePath(String path, Folder start) {
        String []p_text = path.strip().split("/");
        for (int i = 0; i < p_text.length; i++) {
            if (i == p_text.length - 1) {
                this.file = start.getFile(p_text[i]);
            } else {
                if (start.hasFolder(p_text[i])) {
                    start = start.getFolder(p_text[i]);
                } else {
                    return;
                }
            }
        }
    }

    public FilePath(Folder folder) {
        Folder currFolder = folder;

        while (true) {
            if (!currFolder.parent.isRoot) {
                path.add(currFolder);
                currFolder = currFolder.parent;
            } else {
                return;
            }
        }
    }

    public FilePath(File file) {
        Folder currFolder = file.parent;

        while (true) {
            if (!currFolder.parent.isRoot) {
                path.add(currFolder);
                currFolder = currFolder.parent;
            } else {
                return;
            }
        }
    }
}
