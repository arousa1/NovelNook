package class4.spm.novelnook.controller;


import class4.spm.novelnook.pojo.Book;
import class4.spm.novelnook.pojo.Patron;
import class4.spm.novelnook.service.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StaffServiceImpl staffServiceImpl;


    // 获取所有patron信息
    @GetMapping("/patron/show/all")
    public List<Patron> getAllPatrons() {
        return staffServiceImpl.getAllPatrons();
    }

    //根据id获得patron信息
    @GetMapping("/patron/show/{userid}")
    public Patron getPatonById(@PathVariable("userid") String userid) {
        return staffServiceImpl.getPatronById(userid);
    }

    //根据id获得book信息
    @GetMapping("/material/show/{bookid}")
    public Book getBookById(@PathVariable("bookid") String bookid) {
        return staffServiceImpl.getBookById(bookid);
    }




}
