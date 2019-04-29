package com.ncu.bookstore.service;

import com.ncu.bookstore.entity.Admin;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/29/029
 */
public interface AdminService {
    int insertAdmin(Admin admin);
    List<Admin> selectAllAdmin();
    List<Admin> selectAdmin(Admin admin);
    int deleteAdmin(Admin admin);
    int updateAdmin(Admin admin);
}
