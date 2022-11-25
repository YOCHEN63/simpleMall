package com.oliver.simplemall.DAO;

import com.oliver.simplemall.entity.CategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CatDAO {


    List<CategoryDO> selectByCondition(CategoryDO category);

    int addCategory(CategoryDO category);
}
