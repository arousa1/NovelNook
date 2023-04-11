package class4.spm.novelnook.mapper;


import class4.spm.novelnook.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PatronMapper {

    // 获取所有patron信息
    @Select("select * from user where userrole = 'patron'")
    List<User> getAllPatrons();



}
