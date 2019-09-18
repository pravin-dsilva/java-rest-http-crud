package io.openshift.booster.java_rest_http_crud.dao;

import java.util.List;

import io.openshift.booster.java_rest_http_crud.entity.Fruit;

public interface FruitDao {

	List<Fruit> findAll();

	Fruit findFruitById(String id);

	Fruit insertFruit(Fruit theFruit);

	Fruit updateFruit(String id, Fruit theFruit) throws IllegalArgumentException;

	void deleteFruit(String id);

	void deleteFruit(Fruit theFruit);
}
