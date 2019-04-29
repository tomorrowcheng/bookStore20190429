package com.ncu.bookstore.service.serviceImp;

import com.ncu.bookstore.entity.Authors;
import com.ncu.bookstore.dao.AuthorsMapper;
import com.ncu.bookstore.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/28/028
 */
@Service
public class AuthorsServiceImp implements AuthorsService {
    @Autowired
    private AuthorsMapper authorsMapper;

    @Override
    public int insertAuthor(Authors authors) {
        return authorsMapper.insertAuthor(authors);
    }

    @Override
    public List<Authors> selectAllAuthors() {
        return authorsMapper.selectAllAuthors();
    }

    @Override
    public List<Authors> selectAuthors(Authors authors) {
        return authorsMapper.selectAuthors(authors);
    }

    @Override
    public int deleteAuthor(Authors authors) {
        return authorsMapper.deleteAuthor(authors);
    }

    @Override
    public int updateAuthor(Authors authors) {
        return authorsMapper.updateAuthor(authors);
    }
}
