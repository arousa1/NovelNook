package class4.spm.novelnook.controller;

import class4.spm.novelnook.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/user")
    public User getUser(){
        User user=new User("1","dustball","sjh","avatars/Takagi.jpg","Patron","example@qq.com","110");

        return user;
    }
    @GetMapping("/user/{id}")
    public User getUserById(int id){
        User user=
    }

}
