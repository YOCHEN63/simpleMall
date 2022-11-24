package com.oliver.simplemall.Service.impl;

import com.oliver.simplemall.Service.UserService;
import com.oliver.simplemall.entity.UserDTO;
import com.oliver.simplemall.entity.UserDO;
import com.oliver.simplemall.DAO.UserDAO;
import com.oliver.simplemall.entity.UserLoginDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public int registerUser(UserDTO user){
        UserDO userDo = new UserDO();
        BeanUtils.copyProperties(user, userDo);
        userDo.setPassword(encoder.encode(userDo.getPassword()));
        userDo.setUserId(UUID.randomUUID().toString());
        userDo.setUserAuthority(0);
        userDao.insert(userDo);
        return 0;
    }

    @Override
    public UserDO loginUser(UserLoginDTO user){
        UserDO userDetail = userDao.selectByUsername(user.getUsername());
        boolean check = encoder.matches(user.getPassword(), userDetail.getPassword());
        if (check) {
            return userDetail;
        } else {
            return null;
        }
    }
}
