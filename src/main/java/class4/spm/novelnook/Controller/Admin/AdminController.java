package class4.spm.novelnook.Controller.Admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
