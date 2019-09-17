package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Fruit;

public interface FruitDao {

	List<Fruit> findAll();

	Fruit findFruitById(String id);

	Fruit insertFruit(Fruit theFruit);

	Fruit updateFruit(String id, Fruit theFruit) throws IllegalArgumentException;

	// void executeUpdateFruit(Fruit theFruit);

	void deleteFruit(String id);

	void deleteFruit(Fruit theFruit);
}
