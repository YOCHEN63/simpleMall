package com.oliver.simplemall.Service;

import com.oliver.simplemall.entity.ItemDO;
import com.oliver.simplemall.entity.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {

    List<ItemDO> getItems(ItemDO item);

    int addItem(ItemDO item);

}
