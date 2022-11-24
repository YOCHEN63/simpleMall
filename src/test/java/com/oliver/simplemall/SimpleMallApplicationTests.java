package com.oliver.simplemall;

import com.oliver.simplemall.Controller.MainController;
import com.oliver.simplemall.Service.CatService;
import com.oliver.simplemall.Service.ItemService;
import com.oliver.simplemall.Service.UserService;
import com.oliver.simplemall.entity.CategoryDO;
import com.oliver.simplemall.entity.ItemDO;
import com.oliver.simplemall.entity.ItemDTO;
import com.oliver.simplemall.utils.Result;
import org.apache.ibatis.jdbc.Null;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class SimpleMallApplicationTests {

    @Autowired
    DataSource dataSource;

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new MainController()).build();
    }

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

//    @Test
//    void getItems() {
//        ItemDTO itemDTO = new ItemDTO();
//        List<ItemDO> list = itemService.getItems(itemDTO);
//        System.out.println(list.toString());
//    }

    @Test
    void addItem() {
        ItemDO itemDO = new ItemDO();
        itemDO.setItemPrice(100L);
        itemDO.setItemDetail("hahaha");
        itemDO.setCategoryId("8b66c759-1795-49a4-84f1-65c0881112a7");
        itemDO.setManagerId("9f965c31-f4fc-4a71-8be1-7f4b7c1a11b6");
        int status = itemService.addItem(itemDO);
        Result<ItemDO> result = new Result<ItemDO>();
        if (status > 0) {
            result.setCode(200);
            result.setData(itemDO);
            result.setMsg("Success");
        } else {
            result.setCode(400);
            result.setMsg("Error");
        }
        System.out.println(result.toString());
    }

    @Autowired
    CatService catService;

    @Test
    void addCategory() {
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setManagerId("9f965c31-f4fc-4a71-8be1-7f4b7c1a11b6");
        categoryDO.setName("food");
        categoryDO.setAttribute("null");
        catService.addCategory(categoryDO);
    }
}
