package com.oliver.simplemall.Controller;

import com.oliver.simplemall.Service.CatService;
import com.oliver.simplemall.entity.CategoryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CateController {

    @Autowired
    CatService catService;

    @GetMapping(value = "/")
    public List<CategoryDO> getCategories(@RequestBody CategoryDO category) {
        return catService.getCategories(category);
    }

    @PostMapping("/")
    public int addCategory(@RequestBody CategoryDO category) {
        return catService.addCategory(category);
    }
}
