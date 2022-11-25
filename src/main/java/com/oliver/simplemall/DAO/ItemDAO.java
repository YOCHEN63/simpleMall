package com.oliver.simplemall.DAO;

import com.oliver.simplemall.entity.ItemDO;
import com.oliver.simplemall.entity.ItemDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemDAO {

    List<ItemDO> selectByCondition(ItemDO condition);
    int deleteByPrimaryKey(Long id);

    int insert(ItemDO record);

    int insertSelective(ItemDO record);


    int updateByPrimaryKeySelective(ItemDO record);

    int updateByPrimaryKey(ItemDO record);

}
