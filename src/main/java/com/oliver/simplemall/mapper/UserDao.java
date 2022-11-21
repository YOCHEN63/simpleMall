package com.oliver.simplemall.mapper;

import com.oliver.simplemall.entity.UserDo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int insert(UserDo userDo);

    UserDo login(String username);

    UserDo selectByCondition(UserDo userDo);
}
