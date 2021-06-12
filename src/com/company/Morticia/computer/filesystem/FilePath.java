 package com.company.Morticia.computer.filesystem;

import java.util.ArrayList;

 /**
  * This is a class which automatically derives the path of a passes folder or file.
  *
  * @author Morticia
  * @version 1.0
  * @since 6/12/21
  */
public class FilePath {
    public ArrayList<Folder> path;
    public File file;

     /**
      * This constructor initializes the path with the string path and the folder it begins at
      *
      * @param path The string which is to be converted
      * @param start Where the string path begins
      */
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

     /**
      * This constructor works backwards from the folder provided to generate a path beginning at root and ending at the specified folder
      *
      * @param folder The folder to generate the path with
      */
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

     /**
      * This constructor works backwards from the file provided to generate a path beginning at root and ending at the specified file
      *
      * @param file The file to generate the path with
      */
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
