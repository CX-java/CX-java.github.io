package com.cx.atm.mapper;

import com.cx.atm.pojo.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {
        @Select("SELECT * FROM a_user WHERE id = #{uid}")
        User findById(int uid);

        @Select("SELECT * FROM a_user")
        List<User> findAll();

        @Select("SELECT * FROM user LIMIT #{offset}, #{size}")
        List<User> getAllUsersByPage(int page, int size);

        @Insert("INSERT INTO a_user(username, password) VALUES (#{username}, #{password})")
        void saveuser(User user);

        @Update("UPDATE a_user SET username = #{username}, password = #{password} WHERE id = #{uid}")
        void updateuser(User user);

        @Delete("DELETE FROM a_user WHERE id = #{uid}")
        void deleteuser(int uid);
        @Select("SELECT * FROM a_user WHERE username = #{username}")
        User findByName(String username);

    }
