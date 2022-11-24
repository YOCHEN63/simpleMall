package com.oliver.simplemall.DAO;

import com.oliver.simplemall.entity.CategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CatDAO {


    int addCategory(CategoryDO category);
}
