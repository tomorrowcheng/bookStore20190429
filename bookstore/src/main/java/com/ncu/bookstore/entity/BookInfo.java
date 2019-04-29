package com.ncu.bookstore.entity;

import java.util.Date;

/**
 * Created by Tomorrow on 2019/4/29/029
 */
public class BookInfo {
    private Integer bookID;
    private Integer authorID;
    private Integer typeID;
    private String bookName;
    private String picture;
    private Double price;
    private String isdn;
    private Integer bookSize;
    private String publishing;
    private Date pubTime;
    private Integer page;
    private String contentIntro;
    private Integer stockQty;
    private Authors authors;
    private BookType bookType;

    public BookInfo() {
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }


    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public Integer getBookSize() {
        return bookSize;
    }

    public void setBookSize(Integer bookSize) {
        this.bookSize = bookSize;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getContentIntro() {
        return contentIntro;
    }

    public void setContentIntro(String contentIntro) {
        this.contentIntro = contentIntro;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }
}
