package com.oliver.simplemall.Service;

import com.oliver.simplemall.entity.UserDTO;
import com.oliver.simplemall.entity.UserDo;
import com.oliver.simplemall.entity.UserLoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public int registerUser(UserDTO user);

    Boolean loginUser(UserLoginDTO user);
}
