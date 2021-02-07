package com.epam.talixo.api.entities;

import com.google.gson.annotations.SerializedName;

public class Gist {
    private String url;
    private String forks_url;
    private String commits_url;
    private String id;
    private String node_id;
    private String git_pull_url;
    private String git_push_url;
    private String html_url;
    private Files files;
    @SerializedName("public")
    private boolean ppublic;
    private String created_at;
    private String updated_at;
    private String description;
    private Integer comments;
    private String user;
    private String comments_url;
    private Owner owner;
    private boolean truncated;

    public Gist() {
    }

    public Gist(String url, String forks_url, String commits_url, String id, String node_id, String git_pull_url, String git_push_url, String html_url, Files files, boolean ppublic, String created_at, String updated_at, String description, Integer comments, String user, String comments_url, Owner owner, boolean truncated) {
        this.url = url;
        this.forks_url = forks_url;
        this.commits_url = commits_url;
        this.id = id;
        this.node_id = node_id;
        this.git_pull_url = git_pull_url;
        this.git_push_url = git_push_url;
        this.html_url = html_url;
        this.files = files;
        this.ppublic = ppublic;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.comments = comments;
        this.user = user;
        this.comments_url = comments_url;
        this.owner = owner;
        this.truncated = truncated;
    }

    @Override
    public String toString() {
        return "Gist{" +
                "url='" + url + '\'' +
                ", forks_url='" + forks_url + '\'' +
                ", commits_url='" + commits_url + '\'' +
                ", id='" + id + '\'' +
                ", node_id='" + node_id + '\'' +
                ", git_pull_url='" + git_pull_url + '\'' +
                ", git_push_url='" + git_push_url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", files=" + files +
                ", public=" + ppublic +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", description='" + description + '\'' +
                ", comments=" + comments +
                ", user='" + user + '\'' +
                ", comments_url='" + comments_url + '\'' +
                ", owner=" + owner +
                ", truncated=" + truncated +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForks_url() {
        return forks_url;
    }

    public void setForks_url(String forks_url) {
        this.forks_url = forks_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getGit_pull_url() {
        return git_pull_url;
    }

    public void setGit_pull_url(String git_pull_url) {
        this.git_pull_url = git_pull_url;
    }

    public String getGit_push_url() {
        return git_push_url;
    }

    public void setGit_push_url(String git_push_url) {
        this.git_push_url = git_push_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public Files getFiles() {
        return files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }

    public boolean isPpublic() {
        return ppublic;
    }

    public void setPpublic(boolean ppublic) {
        this.ppublic = ppublic;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

}