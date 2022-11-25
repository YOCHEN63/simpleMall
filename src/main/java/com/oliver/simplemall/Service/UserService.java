package com.oliver.simplemall.Service;

import com.oliver.simplemall.entity.UserDO;
import com.oliver.simplemall.entity.UserDTO;
import com.oliver.simplemall.entity.UserLoginDTO;
import org.springframework.stereotype.Service;

public interface UserService {

    int registerUser(UserDTO user);

    UserDO loginUser(UserLoginDTO user);

    Boolean checkToken(String username, String token);

}
