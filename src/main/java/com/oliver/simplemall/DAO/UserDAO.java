package com.oliver.simplemall.DAO;

import com.oliver.simplemall.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
    int insert(UserDO userDo);

    UserDO selectByUsername(String username);

    UserDO selectByCondition(UserDO userDo);
}
