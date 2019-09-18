package io.openshift.booster.java_rest_http_crud.service;

import java.util.List;

import io.openshift.booster.java_rest_http_crud.entity.Fruit;

public interface FruitService {
	List<Fruit> findAll();

	Fruit findById(String id);

	Fruit insertFruit(Fruit theFruit);

	Fruit updateFruit(String id, Fruit theFruit) throws IllegalArgumentException;

	void deleteFruit(String id);

}
