package com.ssm.dao;

import com.ssm.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2021/4/8 - 20:21
 */
public interface BookMapper {
    //    增加一本书
    int addBook(Books books);
//    删除一本书,规范期间加这个注解,
    int deleteBookById(@Param("bookId") int id);
//    修改一本书
    int updateBook(Books books);
//    查询一本书
    Books queryBookById(@Param("bookId") int id);
//    查询全部书
    List<Books> queryAllBook();
//   根据书籍名称查询
    Books queryBookByName(@Param("bookName") String name);
}
