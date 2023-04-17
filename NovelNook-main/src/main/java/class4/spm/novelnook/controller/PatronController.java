package class4.spm.novelnook.controller;


import class4.spm.novelnook.pojo.Book;
import class4.spm.novelnook.pojo.Borrow;
import class4.spm.novelnook.pojo.Patron;
import class4.spm.novelnook.service.PatronServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patron")
public class PatronController {

    @Autowired
    PatronServiceImpl patronServiceImpl;

    //搜索图书信息
    @GetMapping("/search/book/{title}/{author}/{catagory}")
    public List<Book> searchForBook(@PathVariable("title") String title,@PathVariable("author") String author
            ,@PathVariable("catagory") String catagory){
        if (title.isEmpty())
            title = null;
        else  title = "%"+title+"%";
        if (author.isEmpty())
            author = null;
        if (catagory.isEmpty())
            catagory = null;


        List<Book> list = patronServiceImpl.searchForBook(title,author,catagory);
        System.out.println("==============================");
        System.out.println(list);
        System.out.println("==============================");
        return list;
    }

    //获取借阅记录
    @GetMapping("/info/borrow/{userid}")
    public List<Borrow> getBorrowList(@PathVariable("userid") String userid){
        System.out.println(userid);
        return patronServiceImpl.getBorrowList(userid);
    }

    //获取图书信息
    @GetMapping("/info/book/{bookid}")
    public List<Book> getBookInfo(@PathVariable("bookid") String bookid){
        System.out.println(bookid);
        return patronServiceImpl.getBookInfo(bookid);
    }

    //借书
    @GetMapping("/borrow/{userid}/{bookid}")
    public String updateBorrow(@PathVariable("userid") String userid, @PathVariable("bookid") String bookid) {
        return patronServiceImpl.updateBorrow(userid, bookid);
    }
}
