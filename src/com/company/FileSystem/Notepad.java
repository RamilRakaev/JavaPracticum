package com.company.FileSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Notepad {
    private File directory;
    private ArrayList<String> files;
    final String rootDirectory = "/home/rakaev_rg/Recordings/";

    public Notepad() {
        files = new ArrayList<String>();
        directory = new File(rootDirectory);
        directory.mkdir();
    }

    public String addAnEntry(String title, String text) {
        String message = "successful creation!";
        File recordingFile = new File(rootDirectory + title + ".txt");
        try {
            boolean created = recordingFile.createNewFile();
            if (created) {
                message = "The record was not created";
            }
            if (recordingFile.canWrite()) {
                record(recordingFile, text);
            }
        } catch (IOException ex) {
            message = ex.getMessage();
        }
        return message;
    }

    public String record(File file, String text) {
        String message = "successful creation!";
        try (FileWriter stream = new FileWriter(file, true)) {
            stream.write(text);
        } catch (IOException ex) {
            message = ex.getMessage();
        }
        return message;
    }

    public String record(String fileName, String text) {
        String message = "successful creation!";
        try (FileWriter stream = new FileWriter(rootDirectory + fileName + ".txt", true)) {
            stream.write(text);
        } catch (IOException ex) {
            message = ex.getMessage();
        }
        return message;
    }


}
