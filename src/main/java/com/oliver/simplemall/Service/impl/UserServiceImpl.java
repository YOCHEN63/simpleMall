package com.oliver.simplemall.Service.impl;

import com.oliver.simplemall.Service.UserService;
import com.oliver.simplemall.entity.UserDTO;
import com.oliver.simplemall.entity.UserDO;
import com.oliver.simplemall.DAO.UserDAO;
import com.oliver.simplemall.entity.UserLoginDTO;
import com.oliver.simplemall.utils.Token;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private Token tokenUtil;

    @Override
    public int registerUser(UserDTO user){
        UserDO userDo = new UserDO();
        BeanUtils.copyProperties(user, userDo);
        userDo.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        userDo.setUserId(UUID.randomUUID().toString());
        userDo.setUserAuthority(0);
        userDao.insert(userDo);
        return 0;
    }

    @Override
    public UserDO loginUser(UserLoginDTO user){
        UserDO userDetail = userDao.selectByUsername(user.getUsername());
        byte[] password = Base64.getDecoder().decode(userDetail.getPassword());
        if (new String(password, StandardCharsets.UTF_8).equals(user.getPassword())) {
            final Timestamp time = new Timestamp(System.currentTimeMillis());
            final UserDO userDO = new UserDO();
            String token = UUID.randomUUID().toString();
            userDO.setToken(tokenUtil.createToken());
            userDO.setCreateTime(time);
            userDao.update(userDO);
            userDetail.setToken(userDO.getToken());
            return userDetail;
        } else {
            return null;
        }
    }

    @Override
    public Boolean checkToken(String username, String token) {
        UserDO user = userDao.selectByUsername(username);
        return user.getToken().equals(token) && tokenUtil.verify(user.getCreateTime());
    }
}
