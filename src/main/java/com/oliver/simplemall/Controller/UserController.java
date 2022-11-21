package com.oliver.simplemall.Controller;

import com.oliver.simplemall.Service.UserService;
import com.oliver.simplemall.entity.UserDTO;
import com.oliver.simplemall.entity.UserDo;
import com.oliver.simplemall.entity.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDTO user) {
        int result = userService.registerUser(user);
        if (result == 0) {
            return "success";
        }
        return "false";
    }

    @PostMapping("/login")
    public Boolean loginUser(@RequestBody UserLoginDTO user) {
        return userService.loginUser(user);

    }
}
