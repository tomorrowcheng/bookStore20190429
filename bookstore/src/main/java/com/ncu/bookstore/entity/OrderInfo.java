package com.ncu.bookstore.entity;

/**
 * Created by Tomorrow on 2019/5/1/001
 */
public class OrderInfo {
    private Integer orderID;
    private Integer userID;
    private Integer bookID;
    private Integer recID;
    private Integer orderNumber;
    private String expNum;
    private Integer status;
    private BookInfo bookInfo;
    private RecInfo recInfo;
    private Authors authors;

    public OrderInfo() {
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
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

    public Integer getRecID() {
        return recID;
    }

    public void setRecID(Integer recID) {
        this.recID = recID;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getExpNum() {
        return expNum;
    }

    public void setExpNum(String expNum) {
        this.expNum = expNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public RecInfo getRecInfo() {
        return recInfo;
    }

    public void setRecInfo(RecInfo recInfo) {
        this.recInfo = recInfo;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }
}
