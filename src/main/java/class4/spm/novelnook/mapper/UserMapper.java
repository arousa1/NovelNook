package class4.spm.novelnook.mapper;

import org.apache.ibatis.annotations.Select;

import class4.spm.novelnook.pojo.User;

public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public User getUserById(int id);
}
