package com.wee.test.controller.shop.web.controller;

import com.wee.test.controller.shop.domain.entity.Shop;
import com.wee.test.controller.shop.dto.ReportDto;
import com.wee.test.controller.shop.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Api("Shop CRUD controller")
@RequestMapping("/api/v1/shops")
@RestController
public class ShopController {

    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @ApiOperation("Return a list/page of the shop")
    @GetMapping
    public Page<Shop> getAll(final Pageable pageable) {
        return service.findAll(pageable);
    }

    @ApiOperation("Returns a shop according to its identifier")
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getById(
            @ApiParam(name = "id", value = "Shop identifier")
            @PathVariable("id") String id) {
        final Optional<Shop> shop = service.findById(id);

        if(shop.isPresent()) {
            return new ResponseEntity<>(shop.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // create a specific exception (not found)
    }

    @ApiOperation(value = "Update shop information ", response = Shop.class)
    @PutMapping(path = "/{id}")
    public Shop updateCreate(
            @ApiParam(name = "id", value = "Shop identifier")
            @PathVariable("id") String id,
            @RequestBody Shop shop) {
        return service.update(id, shop);
    }

    @ApiOperation(value = "Update shop information ", response = Shop.class)
    @PostMapping
    public Shop create(@RequestBody Shop shop) {
        return service.create(shop);
    }

    @ApiOperation(value = "Returns the report of a Shop with the quantity of items. ", response = ReportDto.class)
    @GetMapping(path = "/report/{id}")
    public ReportDto report(
            @ApiParam(name = "id", value = "Shop identifier")
            @PathVariable("id") String id) {
        return service.report(id);
    }
}
