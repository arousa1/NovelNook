package class4.spm.novelnook.mapper;


import class4.spm.novelnook.pojo.Book;
import class4.spm.novelnook.pojo.Patron;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StaffMapper {

    // 获取所有patron信息
    @Select("select * from patron")
    List<Patron> getAllPatrons();

    //根据Id获得patron信息
    @Select("select * from patron where userid = #{userid}")
    Patron getPatronById(@Param("userid") String userid);

    //根据Id获得book信息
    @Select("select * from book where bookid = #{bookid}")
    Book getBookById(@Param("bookid") String bookid);

    //删除patron
    @Delete("DELETE FROM patron WHERE userid = #{userid};")
    int DeletePatron(@Param("userid") String userid);


    //增加patron
    @Insert("INSERT INTO patron VALUES (#{userid},CONCAT(#{lastname},#{firstname}),#{password},#{firstname},#{lastname},#{email},#{telephone},#{avatarUrl});")
    int AddPatron(@Param("userid") String userid, @Param("password") String password
            ,@Param("firstname" ) String firstname,@Param("lastname") String lastname
            , @Param("email") String email, @Param("telephone") String telephone,@Param("avatarUrl") String avatarUrl);

}
