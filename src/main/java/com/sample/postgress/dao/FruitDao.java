package com.sample.postgress.dao;

import java.util.List;

import com.sample.postgress.entity.Fruit;

public interface FruitDao {

	List<Fruit> findAll();

	void insertFruit(Fruit theFruit);

	void updateFruit(Fruit theFruit);

	void executeUpdateFruit(Fruit theFruit);

	public void deleteFruit(Fruit theFruit);
}
