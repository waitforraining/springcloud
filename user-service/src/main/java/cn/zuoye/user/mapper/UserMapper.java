package cn.zuoye.user.mapper;

import cn.zuoye.user.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    
    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);

    @Select("select * from tb_user")
    List<User> getAllUsers();

    @Insert("insert into tb_user(username,address)\n" +
            "values(#{username},#{address}) ")
    boolean addUser(User user);

    @Delete("delete from tb_user where id = #{userId}")
    boolean deleteUserById(Long userId);
}