package com.ncu.bookstore.dao;

import com.ncu.bookstore.entity.Test;

public interface TestMapper {
    Test selectByPrimaryKey(Integer id);
}
