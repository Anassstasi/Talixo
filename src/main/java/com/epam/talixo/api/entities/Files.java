package com.epam.talixo.api.entities;

public class Files {
    private Filename filename;

    public Files() {
    }

    public Files(Filename filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Files{" +
                "filename=" + filename +
                '}';
    }

    public Filename getFilename() {
        return filename;
    }

    public void setFilename(Filename filename) {
        this.filename = filename;
    }

}