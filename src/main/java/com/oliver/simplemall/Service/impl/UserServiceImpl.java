package com.oliver.simplemall.Service.impl;

import com.oliver.simplemall.Service.UserService;
import com.oliver.simplemall.entity.UserDTO;
import com.oliver.simplemall.entity.UserDo;
import com.oliver.simplemall.entity.UserLoginDTO;
import com.oliver.simplemall.mapper.UserDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public int registerUser(UserDTO user){
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user, userDo);
        userDo.setPassword(encoder.encode(userDo.getPassword()));
        userDo.setId(UUID.randomUUID().toString());
        userDo.setUserAuthority(0);
        userDao.insert(userDo);
        return 0;
    }

    @Override
    public Boolean loginUser(UserLoginDTO user){
        String password =  userDao.login(user.getUsername()).getPassword();
        return encoder.matches(user.getPassword(), password);
    }
}
