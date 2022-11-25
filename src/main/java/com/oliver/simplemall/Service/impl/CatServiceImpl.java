package com.oliver.simplemall.Service.impl;

import com.oliver.simplemall.DAO.CatDAO;
import com.oliver.simplemall.Service.CatService;
import com.oliver.simplemall.entity.CategoryDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    CatDAO catDAO;

    @Override
    public int addCategory(CategoryDO category) {
        category.setCatId(UUID.randomUUID().toString());
        return catDAO.addCategory(category);
    }

    @Override
    public List<CategoryDO> getCategories(CategoryDO category) {
        return catDAO.selectByCondition(category);
    }
}
