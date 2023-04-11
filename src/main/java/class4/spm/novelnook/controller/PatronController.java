package class4.spm.novelnook.controller;

import class4.spm.novelnook.mapper.PatronMapper;
import class4.spm.novelnook.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patron")
public class PatronController {

    @Autowired
    PatronMapper patronMapper;

    // 获取所有员工信息
    @GetMapping("/getAll")
    public List<User> getAllPatrons(){
        return patronMapper.getAllPatrons();
    }



}
