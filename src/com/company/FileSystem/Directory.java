package com.company.FileSystem;

import java.util.ArrayList;

public class Directory extends FilesystemElement {

    private ArrayList<FilesystemElement> elements;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        elements = new ArrayList<>();
        isDirectory = true;
    }

    public void move(Directory newParent) {
        parent.cutElement(this);
        parent = newParent;
        parent.pasteElement(this);
    }

    public void cutElement(FilesystemElement element) {
        element.parent = null;
        elements.remove(element);
    }

    public void pasteElement(FilesystemElement element) {
        element.parent = this;
        elements.add(element);
    }

    public int getSize() {
        return elements.size();
    }

    public ArrayList<FilesystemElement> getAllElements() {
        return new ArrayList<FilesystemElement>(elements);
    }

    public ArrayList<FilesystemElement> getDirectories() {
        ArrayList<FilesystemElement> directories = new ArrayList<>();
        for (FilesystemElement directory : elements) {
            if (isDirectory) {
                directories.add(directory);
            }
        }
        return directories;
    }

    public ArrayList<FilesystemElement> getFiles() {
        ArrayList<FilesystemElement> files = new ArrayList<>();
        for (FilesystemElement directory : elements) {
            if (!isDirectory) {
                files.add(directory);
            }
        }
        return files;
    }
}
