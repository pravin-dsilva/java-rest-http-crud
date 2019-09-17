package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Fruit;

public interface FruitService {
	List<Fruit> findAll();

	void insertFruit(Fruit theFruit);

	void updateFruit(Fruit theFruit);

	void executeUpdateFruit(Fruit theFruit);

	void deleteFruit(Fruit theFruit);
	
}
