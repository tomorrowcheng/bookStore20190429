package com.ncu.bookstore.service.serviceImp;

import com.ncu.bookstore.dao.RecInfoMapper;
import com.ncu.bookstore.entity.RecInfo;
import com.ncu.bookstore.service.RecInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/30/030
 */
@Service
public class RecInfoServiceImp implements RecInfoService {
    @Autowired
    private RecInfoMapper recInfoMapper;

    @Override
    public int insertRecInfo(RecInfo recInfo) {
        return recInfoMapper.insertRecInfo(recInfo);
    }

    @Override
    public int deleteRecInfo(RecInfo recInfo) {
        return recInfoMapper.deleteRecInfo(recInfo);
    }

    @Override
    public int updateRecInfo(RecInfo recInfo) {
        return recInfoMapper.updateRecInfo(recInfo);
    }

    @Override
    public List<RecInfo> selectRecInfo(RecInfo recInfo) {
        return recInfoMapper.selectRecInfo(recInfo);
    }
}
