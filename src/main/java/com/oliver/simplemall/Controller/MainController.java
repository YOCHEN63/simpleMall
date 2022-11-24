package com.oliver.simplemall.Controller;

import com.oliver.simplemall.Service.ItemService;
import com.oliver.simplemall.Service.UserService;
import com.oliver.simplemall.entity.*;
import com.oliver.simplemall.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @PostMapping("/login")
    public UserDO login(@RequestBody UserLoginDTO user) {
        return userService.loginUser(user);

    }

    @PostMapping("/register")
    public Result<String> registerUser(@RequestBody UserDTO user) {
        int status = userService.registerUser(user);
        Result<String> result = new Result<String>();
        if (status == 0) {
            result.setCode(200);
            result.setData("Success");
            return result;
        }
        result.setCode(400);
        result.setData("Fail");
        return result;
    }

//    @GetMapping("/items")
//    public Result<List<ItemDO>> getItems(@RequestBody ItemDTO item) {
//        Result<List<ItemDO>> result = new Result<List<ItemDO>>();
//        List<ItemDO> items = itemService.getItems(item);
//        result.setData(items);
//        return result;
//    }


}
