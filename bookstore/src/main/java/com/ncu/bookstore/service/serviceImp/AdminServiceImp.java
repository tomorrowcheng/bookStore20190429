package com.ncu.bookstore.service.serviceImp;

import com.ncu.bookstore.entity.Admin;
import com.ncu.bookstore.dao.AdminMapper;
import com.ncu.bookstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/29/029
 */
@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public List<Admin> selectAllAdmin() {
        return adminMapper.selectAllAdmin();
    }

    @Override
    public List<Admin> selectAdmin(Admin admin) {
        return adminMapper.selectAdmin(admin);
    }

    @Override
    public int deleteAdmin(Admin admin) {
        return adminMapper.deleteAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }
}
