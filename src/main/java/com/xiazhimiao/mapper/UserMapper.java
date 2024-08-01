package com.xiazhimiao.mapper;

import com.xiazhimiao.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UserMapper {


    @Select("select * from `examination-system`.users where username=#{username} and password=#{password}")
    User getByUsernameAndPassword(User user);

    @Insert("INSERT INTO `examination-system`.users (username,password,created_at) VALUES (#{username}, #{password},now())")
    int register(User user);

    @Select("select *from `examination-system`.users where username=#{username}")
    User getUsername(User user);

    @Select("select id,name,username from `examination-system`.users where id=#{id}")
    User userInfoService(Integer id);
}

