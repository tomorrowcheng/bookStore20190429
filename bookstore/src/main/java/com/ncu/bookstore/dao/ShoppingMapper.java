package com.ncu.bookstore.dao;

import com.ncu.bookstore.entity.Shopping;

import java.util.List;

/**
 * Created by Tomorrow on 2019/5/1/001
 */
public interface ShoppingMapper {
    int insertShopping(Shopping shopping);
    int deleteShopping(Shopping shopping);
    int updateShopping(Shopping shopping);
    List<Shopping> selectShopping(Shopping shopping);
}
