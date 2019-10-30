package com.wee.test.controller.shop.service;

import com.wee.test.controller.shop.domain.entity.Shop;
import com.wee.test.controller.shop.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public long countItemsByShop(final Shop shop) {
        return itemRepository.countByShop(shop);
    }
}
