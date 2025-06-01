package com.example.weak3.weak3;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.weak3.entities.ProductsEntity;
import com.example.weak3.repositories.ProductRepositories;

@SpringBootTest
class Weak3ApplicationTests {


	@Autowired
	ProductRepositories productsRepositories;

	@Test
	void contextLoads() {
	}

	@Test
	void insertData(){
		ProductsEntity product = ProductsEntity.builder()
		.sku("nesle")
		.title("Nesle23")
		.price(BigDecimal.valueOf(123.43))
		.quantity(12)
		.build();
		ProductsEntity saveProucts = productsRepositories.save(product);
		System.out.println(saveProucts);
	}

}
