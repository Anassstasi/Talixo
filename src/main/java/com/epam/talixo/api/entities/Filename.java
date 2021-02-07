package com.epam.talixo.api.entities;

public class Filename {
    private String content;
    private String filename;
    private String truncated;
    private String language;
    private String type;
    private String raw_url;
    private String size;

    public Filename() {
    }

    public Filename(String content, String filename, String truncated, String language, String type, String raw_url, String size) {
        this.content = content;
        this.filename = filename;
        this.truncated = truncated;
        this.language = language;
        this.type = type;
        this.raw_url = raw_url;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Filename{" +
                "content='" + content + '\'' +
                ", filename='" + filename + '\'' +
                ", truncated='" + truncated + '\'' +
                ", language='" + language + '\'' +
                ", type='" + type + '\'' +
                ", raw_url='" + raw_url + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTruncated() {
        return truncated;
    }

    public void setTruncated(String truncated) {
        this.truncated = truncated;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRaw_url() {
        return raw_url;
    }

    public void setRaw_url(String raw_url) {
        this.raw_url = raw_url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}