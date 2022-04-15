package com.ssm.service;

import com.ssm.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2021/4/8 - 20:50
 */
//业务层的方法基本也是与dao层相似的，毕竟就是这几个功能
public interface BookService  {
    //    增加一本书
    int addBook(Books books);
    //    删除一本书,规范期间加这个注解
    int deleteBookById(int id);
    //    修改一本书
    int updateBook(Books books);
    //    查询一本书
    Books queryBookById(int id);
    //    查询全部书
    List<Books> queryAllBook();
//    按照书名查书籍
    Books queryBookByName(String name);
}
