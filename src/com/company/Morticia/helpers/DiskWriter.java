package com.company.Morticia.helpers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// Will need a windows version, how you specify paths there is different
public class DiskWriter {
    public static void writeFile(String name, String path, ArrayList<String> data) {
        String fullPath = path;
        if (path.endsWith("/")) {
            fullPath += name;
        } else {
            fullPath += "/" + name;
        }

        File file = new File(fullPath);
        try {
            file.createNewFile();
            java.io.FileWriter writer = new java.io.FileWriter(fullPath);
            for (String i : data) {
                writer.write(i + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error while attempting to create file.");
            e.printStackTrace();
        }
    }

    public static void makeFolder(String path, String name) {
        String fullPath = path;
        if (path.endsWith("/")) {
            fullPath += name;
        } else {
            fullPath += "/" + name;
        }

        File file = new File(fullPath);
        file.mkdir();
    }

    // Also works for folders
    public static boolean hasChild(String path, String fileName) {
        File file = new File(path);
        String []files = file.list();
        for (String i : files) {
            if (i.equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public static String[] getChildren(String path) {
        File file = new File(path);
        return file.list();
    }
}
