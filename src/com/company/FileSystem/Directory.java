package com.company.FileSystem;

import java.io.File;

public class Directory {
    final String path = "/home/rakaev_rg/";
    private File directory;
    private boolean isExists = true;

    public Directory(String nameDirectory) {
        directory = new File(path + nameDirectory);
        directory.mkdir();
    }

    public void move(String nameNewDirectory) {
        if (isExists) {
            File newDir = new File(path + nameNewDirectory);
            newDir.mkdir();
            File[] files = directory.listFiles();
            for (File file : files) {
                file.renameTo(new File(newDir, file.getName()));
            }
            directory = newDir;
        }
    }

    public void removeDirectory() {
        File[] files = this.directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                Directory dir = new Directory(file.getPath());
                dir.removeDirectory();
            } else {
                file.delete();
            }
        }
        directory.delete();
        directory = null;
        isExists = false;
    }
}
