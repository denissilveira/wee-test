package com.wee.test;

import com.wee.test.controller.shop.domain.entity.Shop;
import com.wee.test.controller.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestApplication {

	@Autowired
	private ShopRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@PostConstruct
	public void init() {
		var entity = new Shop();
		entity.setName("shop a");
		repository.save(entity);
		entity = new Shop();
		entity.setName("shop b");
		repository.save(entity);
	}
}
