package com.ncu.bookstore.service.serviceImp;

import com.ncu.bookstore.entity.BookType;
import com.ncu.bookstore.dao.BookTypeMapper;
import com.ncu.bookstore.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/28/028
 */
@Service
public class BookTypeServiceImp implements BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public int insertBookType(BookType bookType) {
        return bookTypeMapper.insertBookType(bookType);
    }

    @Override
    public List<BookType> selectAllType() {
        return bookTypeMapper.selectAllType();
    }

    @Override
    public List<BookType> selectBookType(BookType bookType) {
        return bookTypeMapper.selectBookType(bookType);
    }

    @Override
    public int deleteBookType(BookType bookType) {
        return bookTypeMapper.deleteBookType(bookType);
    }

    @Override
    public int updateBookType(BookType bookType) {
        return bookTypeMapper.updateBookType(bookType);
    }
}
