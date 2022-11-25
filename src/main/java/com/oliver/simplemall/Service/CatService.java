package com.oliver.simplemall.Service;

import com.oliver.simplemall.entity.CategoryDO;

import java.util.List;

public interface CatService {

    List<CategoryDO> getCategories(CategoryDO category);
    int addCategory(CategoryDO category);
}
