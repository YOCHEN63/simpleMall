package com.oliver.simplemall.Service.impl;

import com.oliver.simplemall.DAO.ItemDAO;
import com.oliver.simplemall.Service.ItemService;
import com.oliver.simplemall.entity.ItemDO;
import com.oliver.simplemall.entity.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDAO itemDAO;

    @Override
    public List<ItemDO> getItems(ItemDO itemDO) {
        return itemDAO.selectByCondition(itemDO);
    }

    @Override
    public int addItem(ItemDO itemDO) {
        itemDO.setItemId(UUID.randomUUID().toString());
        return itemDAO.insert(itemDO);
    }
}
