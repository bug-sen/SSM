import com.ssm.pojo.Books;
import com.ssm.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author
 * @date 2021/4/9 - 20:27
 */
//测试能否查出来所有书籍
public class Mytest {
    @Test
    public void test(){
//        引入最顶端的配置文件，保证所有的bean都能测到,BookServiceImpl报错那就去这个的name测
        ApplicationContext context = new ClassPathXmlApplicationContext("apllicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
//        调用queryallbook方法将查询的输出
        for (Books books : bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }
    }
}
