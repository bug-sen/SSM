package com.ssm.controller;

import com.ssm.pojo.Books;
import com.ssm.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2021/4/9 - 19:57
 */
@Controller
@RequestMapping("/book")
public class BookController {
    //controller调用service层，将service注入进来,Qualifier里面对应service.xml中的name，这样就又与mapper关联起来了
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

//    查询全部书籍，并且返回到一个展示页面
    @RequestMapping("/allbook")
    public String list(Model model){
//        调用业务层的对应方法
        List<Books> list = bookService.queryAllBook();
//        返回给前端展示出来
        model.addAttribute("list",list);
        return "allbook";
    }
//    跳转到新增书籍页面，这里面只是跳转到addbook页面就行了，具体实现再另外写
    @RequestMapping("/toaddbook")
    public String toaddbook(){
        return "addbook";
    }
//    添加书籍的方法
    @RequestMapping("/addbook")
    public String addbook(Books books){
     //   System.out.println("book:"+books);//测试一下
        bookService.addBook(books);
        return "redirect:/book/allbook";//重定向到书籍展示页，更严谨，直接返回“allbook”也可以，
    }
    //    跳转到修改书籍页面，自带查询功能，你点哪个书籍，那个书籍的信息就会出现在修改的页面
    @RequestMapping("/toupdatebook")
    public String toupdate(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("qbook",books);
        return "updatebook";
    }
//    修改书籍
    @RequestMapping("updatebook")
    public String updatebook(Books books){
        System.out.println("book:"+books);//测试一下
        bookService.updateBook(books);
        return "redirect:/book/allbook"; 
    }
//    删除书籍 ,使用一下restful风格
    @RequestMapping("/deletebook/{bookid}")
    public String deletebook(@PathVariable("bookid") int id,Model model){
        bookService.deleteBookById(id);
        return "redirect:/book/allbook";
    }
//    根据书名搜索书籍,要返回显示东西的都用Model返回，与前端input中的name
    @RequestMapping("querybookname")
//    这里面的参数名字必须和前端输入书籍名字框的name一样！！！
    public String querybookname(String querybookname,Model model){
        Books books = bookService.queryBookByName(querybookname);
//        我们查完之后还在allbook页面展示，但allbook里面是一个List所以这里创建一个
        List<Books> list = new ArrayList<>();
        list.add(books);
        if(books == null){
            list = bookService.queryAllBook();
            model.addAttribute("error","未查到！");
        }
        model.addAttribute("list",list);
        return "allbook";
    }
}
