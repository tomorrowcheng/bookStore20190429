package com.ncu.bookstore.entity;

/**
 * Created by Tomorrow on 2019/5/1/001
 */
public class Shopping {
    private Integer shoppingID;
    private Integer userID;
    private Integer bookID;
    private Integer number;
    private BookInfo bookInfo;
    private Authors authors;

    public Shopping() {
    }

    public Integer getShoppingID() {
        return shoppingID;
    }

    public void setShoppingID(Integer shoppingID) {
        this.shoppingID = shoppingID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }
}
