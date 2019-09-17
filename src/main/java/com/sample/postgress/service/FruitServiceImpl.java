package com.sample.postgress.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.postgress.dao.FruitDao;
import com.sample.postgress.entity.Fruit;
@Component
public class FruitServiceImpl implements FruitService{
	@Resource 
	FruitDao fruitDao;
	@Override
	public List<Fruit> findAll() {
		return fruitDao.findAll();
	}
	@Override
	public void insertFruit(Fruit theFruit) {
		fruitDao.insertFruit(theFruit);
		
	}
	@Override
	public void updateFruit(Fruit theFruit) {
		fruitDao.updateFruit(theFruit);
		
	}
	@Override
	public void executeUpdateFruit(Fruit theFruit) {
		fruitDao.executeUpdateFruit(theFruit);
		
	}

	@Override
	public void deleteFruit(Fruit theFruit) {
		fruitDao.deleteFruit(theFruit);
		
	}
}
