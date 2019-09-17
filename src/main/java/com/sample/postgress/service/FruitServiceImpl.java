package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.FruitDao;
import com.sample.postgress.entity.Fruit;

@Component
public class FruitServiceImpl implements FruitService {
	@Resource
	FruitDao fruitDao;

	@Override
	public List<Fruit> findAll() {
		return fruitDao.findAll();
	}

	@Override
	public Fruit insertFruit(Fruit theFruit) {
		return fruitDao.insertFruit(theFruit);
	}

	@Override
	public Fruit updateFruit(String id, Fruit theFruit) throws IllegalArgumentException{
		return fruitDao.updateFruit(id, theFruit);
	}

	@Override
	public void deleteFruit(String id) {
		fruitDao.deleteFruit(id);

	}

	@Override
	public Fruit findById(String id) {
		return fruitDao.findFruitById(id);
	}
}
