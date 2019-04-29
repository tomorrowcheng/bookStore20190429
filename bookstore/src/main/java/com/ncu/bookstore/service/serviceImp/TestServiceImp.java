package com.ncu.bookstore.service.serviceImp;

import com.ncu.bookstore.dao.TestMapper;
import com.ncu.bookstore.entity.Test;
import com.ncu.bookstore.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试服务
 */
@Service("testService")
public class TestServiceImp implements TestService {
    @Autowired(required = false)
    private TestMapper testMapper = null;

    public Test getById(int id) {
        return testMapper.selectByPrimaryKey(id);
    }
}
