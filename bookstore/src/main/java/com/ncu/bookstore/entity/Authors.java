package com.ncu.bookstore.entity;

/**
 * Created by Tomorrow on 2019/4/28/028
 */
public class Authors {
    private Integer authorID;

    private String authorName;

    private String description;

    public Authors() {
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
