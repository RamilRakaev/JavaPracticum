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

    //TODO: an error crashes, files equal null during recursion
    public void removeDirectory() {
        throws IOException {

            if (directory.isDirectory()) {

                //directory is empty, then delete it
                if (directory.list().length == 0) {

                    directory.delete();
//                System.out.println("Directory is deleted : "+ file.getAbsolutePath());

                } else {

                    //list all the directory contents
                    String files[] = directory.list();

                    for (String temp : files) {
                        //construct the file structure
                        Directory
                        File fileDelete = new File(directory, temp);

                        //recursive delete
                        removeDirectory(fileDelete);
                    }

                    //check the directory again, if empty then delete it
                    if (directory.list().length == 0) {
                        directory.delete();
//                    System.out.println("Directory is deleted : " + file.getAbsolutePath());
                    }
                }

            } else {
                //if file, then delete it
                directory.delete();
//            System.out.println("File is deleted : " + file.getAbsolutePath());
            }
        directory = null;
        isExists = false;
    }


}
