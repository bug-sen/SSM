package com.ssm.service;

import com.ssm.dao.BookMapper;
import com.ssm.pojo.Books;

import java.util.List;

/**
 * @author
 * @date 2021/4/8 - 20:51
 */
public class BookServiceImpl implements BookService {
//    service层调用dao层：组合dao层,注入
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
//return 实现对dao层的调用
    @Override
    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public Books queryBookByName(String name) {
        return bookMapper.queryBookByName(name);
    }

}
