package com.wee.test.controller.shop.repository;

import com.wee.test.controller.shop.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {

    @Query("SELECT s FROM Shop s LEFT JOIN FETCH s.items where s.id = :id")
    Shop findWithItemsById(final String id);
}