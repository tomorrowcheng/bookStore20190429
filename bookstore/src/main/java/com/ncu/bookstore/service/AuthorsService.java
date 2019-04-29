package com.ncu.bookstore.service;

import com.ncu.bookstore.entity.Authors;

import java.util.List;

/**
 * Created by Tomorrow on 2019/4/28/028
 */
public interface AuthorsService {
    int insertAuthor(Authors authors);
    List<Authors> selectAllAuthors();
    List<Authors> selectAuthors(Authors authors);
    int deleteAuthor(Authors authors);
    int updateAuthor(Authors authors);
}
