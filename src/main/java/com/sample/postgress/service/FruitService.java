package com.sample.postgress.service;

import java.util.List;

import com.sample.postgress.entity.Fruit;

public interface FruitService {
	List<Fruit> findAll();

	Fruit findById(String id);

	Fruit insertFruit(Fruit theFruit);

	Fruit updateFruit(String id, Fruit theFruit) throws IllegalArgumentException;

	// void executeUpdateFruit(Fruit theFruit);

	void deleteFruit(String id);

}
