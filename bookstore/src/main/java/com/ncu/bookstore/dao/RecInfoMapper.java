package com.ncu.bookstore.dao;

import com.ncu.bookstore.entity.RecInfo;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/30/030
 */
public interface RecInfoMapper {
    int insertRecInfo(RecInfo recInfo);
    int deleteRecInfo(RecInfo recInfo);
    int updateRecInfo(RecInfo recInfo);
    List<RecInfo> selectRecInfo(RecInfo recInfo);
}
