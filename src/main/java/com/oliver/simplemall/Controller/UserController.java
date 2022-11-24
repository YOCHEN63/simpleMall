package com.oliver.simplemall.Controller;

import com.oliver.simplemall.Service.UserService;
import com.oliver.simplemall.entity.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{user}")
public class UserController {

    @Autowired
    private UserService userService;


}
