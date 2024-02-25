package com.zerek.bigevent.mapper;

import com.zerek.bigevent.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author zerek
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2024-02-23 17:05:30
* @Entity com.zerek.bigevent.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where username=#{username}")
    User findByUsername(@Param("username") String username);

    @Insert("insert into user (username, password, create_time, update_time) " +
            "values(#{username}, #{password}, now(), now())")
    void add(@Param("username") String username,
             @Param("password")String md5String);

    @Update("update user set nickname=#{nickname}, email=#{email}, update_time=#{updateTime} where id=#{id}")
    void update(User user);

    @Update(("update user set user_pic=#{avatarUrl}, update_time=now() where id=#{id}"))
    void updateAvatar(String avatarUrl, Integer id);

    @Update(("update user set password=#{password}, update_time=now() where id=#{id}"))
    void  updatePwd(@Param("password") String md5String, Integer id);
}




