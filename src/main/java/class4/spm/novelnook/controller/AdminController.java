package class4.spm.novelnook.controller;

import class4.spm.novelnook.mapper.AdminMapper;
import class4.spm.novelnook.mapper.PatronMapper;
import class4.spm.novelnook.pojo.Staff;
import class4.spm.novelnook.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminMapper adminMapper;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


//    @GetMapping("/staff")
//    public Staff getStaff(){
//    }
    @GetMapping("/staff/{username}")
    public List<Staff> getStaffByUsername(@PathVariable("username") String username){
        System.out.println(username);
        List<Staff> list=adminMapper.getStaffByUserName(username);
//        if (list.isEmpty()){
//            list.add(new Staff("sjh","123","Darth","Vader","123456","1@empire.com"));
//        }
        return list;
    }

}
