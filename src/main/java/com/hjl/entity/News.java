package com.hjl.entity;

import java.util.Date;

public class News {
    private String title;
    private Date date;
    private String category;
    private String authorName;
    private String url;
    private String thumbnailPicS;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailPicS() {
        return thumbnailPicS;
    }

    public void setThumbnailPicS(String thumbnailPicS) {
        this.thumbnailPicS = thumbnailPicS;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", authorName='" + authorName + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailPicS='" + thumbnailPicS + '\'' +
                '}';
    }
}
