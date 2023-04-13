package class4.spm.novelnook.mapper;


import class4.spm.novelnook.pojo.Book;
import class4.spm.novelnook.pojo.Patron;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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



}
