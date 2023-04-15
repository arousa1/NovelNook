package class4.spm.novelnook.mapper;


import class4.spm.novelnook.pojo.Staff;
import class4.spm.novelnook.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    @Select("select * from user where userrole = 'patron'")
    List<User> getAllPatrons();

    @Select("select * from staff where username like '%${username}%'")
    List<Staff> getStaffByUserName(String username);//用来查找

    @Select("select * from staff ")//用来显示界面
    List<Staff> ShowStaff();

    @Delete("delete from staff where username = '%${username}%'")
    List<Staff> deleteStaffByUserName(String username);//用来删除
}
