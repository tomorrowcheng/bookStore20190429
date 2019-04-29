package com.ncu.bookstore.entity;

/**
 * Created by Tomorrow on 2019/4/28/028
 */
public class BookType {
    private Integer typeID;

    private String  typeName;

    public BookType(){
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
