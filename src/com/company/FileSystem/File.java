package com.company.FileSystem;

public class File extends FilesystemElement {

    public File(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        isDirectory = false;
    }

    public void move(Directory newParent) {
        parent.cutElement(this);
        parent.pasteElement(this);
    }
}
