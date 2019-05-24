package com.ncu.bookstore.dao;

import com.ncu.bookstore.entity.User;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/30/030
 */
public interface UserMapper {
    int insertUser(User user);
    List<User> selectAllUser();
    List<User> selectUser(User user);
    List<User> selectUserOnly(User user);
    int deleteUser(User user);
    int updateUser(User user);
}
