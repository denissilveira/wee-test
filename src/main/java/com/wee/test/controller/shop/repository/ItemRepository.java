package com.wee.test.controller.shop.repository;

import com.wee.test.controller.shop.domain.entity.Item;
import com.wee.test.controller.shop.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

    long countByShop(final Shop shop);
}
