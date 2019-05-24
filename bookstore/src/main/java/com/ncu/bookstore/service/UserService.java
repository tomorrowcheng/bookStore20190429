package com.ncu.bookstore.service;

import com.ncu.bookstore.entity.User;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/30/030
 */
public interface UserService {
    int insertUser(User user);
    List<User> selectAllUser();
    List<User> selectUser(User user);
    List<User> selectUserOnly(User user);
    int deleteUser(User user);
    int updateUser(User user);
}
