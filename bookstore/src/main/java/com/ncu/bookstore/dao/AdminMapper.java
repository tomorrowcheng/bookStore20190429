package com.ncu.bookstore.dao;

import com.ncu.bookstore.entity.Admin;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/29/029
 */
public interface AdminMapper {
    int insertAdmin(Admin admin);
    List<Admin> selectAllAdmin();
    List<Admin> selectAdmin(Admin admin);
    int deleteAdmin(Admin admin);
    int updateAdmin(Admin admin);
}
