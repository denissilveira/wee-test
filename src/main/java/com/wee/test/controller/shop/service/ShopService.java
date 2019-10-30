package com.wee.test.controller.shop.service;

import com.wee.test.controller.shop.domain.entity.Shop;
import com.wee.test.controller.shop.dto.ReportDto;
import com.wee.test.controller.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository repository;

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public ReportDto report(final String shopId) {

        final Shop shop = repository.findWithItemsById(shopId);
        if(shop != null) {
            return new ReportDto(shop.getName(), shop.getItems().size()); // change this create count
        }
        return null; // exception shopping not found (404)
    }

    public Shop create(final Shop shop) {
        return repository.save(shop);
    }

    public Page<Shop> findAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Shop> findById(final String id) {
        return repository.findById(id);
    }

    public Shop update(final String id, final Shop shop) {

        Optional<Shop> shopOptional = repository.findById(id);

        if(shopOptional.isPresent()) {
            Shop shopDb = shopOptional.get();
            shop.setName(shop.getName());
            return repository.save(shopDb);
        }
        return repository.save(shop); // validate the rules
    }
}
