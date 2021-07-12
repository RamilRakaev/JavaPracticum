package com.company.FileSystem;

public abstract class FilesystemElement {
    protected String name;
    protected Directory parent;
    protected boolean isDirectory;

    public String getName() {
        return name;
    }

    public String getFullName() {
        return parent == null ? name : parent.getFullName() + "/" + name;
    }
}
