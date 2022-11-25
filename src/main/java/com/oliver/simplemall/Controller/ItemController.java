package com.oliver.simplemall.Controller;

import com.oliver.simplemall.Service.ItemService;
import com.oliver.simplemall.Service.UserService;
import com.oliver.simplemall.entity.ItemDO;
import com.oliver.simplemall.utils.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{userId}/Items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @Autowired
    Token tokenUtil;

    @GetMapping("/")
    public List<ItemDO> getItems(@PathVariable String userId, @RequestBody ItemDO itemDO) {
        tokenUtil.checkToken(userId, )
        return itemService.getItems(itemDO);
    }

    @PostMapping("/")
    public int addItems(@RequestBody ItemDO itemDO) {
        return itemService.addItem(itemDO);
    }

}
