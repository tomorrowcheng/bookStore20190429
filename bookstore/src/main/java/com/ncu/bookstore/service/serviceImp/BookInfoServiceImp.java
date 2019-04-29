package com.ncu.bookstore.service.serviceImp;

import com.ncu.bookstore.dao.BookInfoMapper;
import com.ncu.bookstore.entity.BookInfo;
import com.ncu.bookstore.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/29/029
 */
@Service
public class BookInfoServiceImp implements BookInfoService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public int insertBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.insertBookInfo(bookInfo);
    }

    @Override
    public int deleteBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.deleteBookInfo(bookInfo);
    }

    @Override
    public int updateBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.updateBookInfo(bookInfo);
    }

    @Override
    public List<BookInfo> selectAllBookInfo() {
        return bookInfoMapper.selectAllBookInfo();
    }

    @Override
    public List<BookInfo> selectBookInfo(BookInfo bookInfo) {
        return bookInfoMapper.selectBookInfo(bookInfo);
    }
}
