package com.sample.postgress.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.postgress.entity.Fruit;
import com.sample.postgress.service.FruitService;

@RestController
@RequestMapping("/postgressApp")
public class ApplicationController {

	@Resource 
	FruitService fruitService;
	
	@GetMapping(value = "/fruitList")
	public List<Fruit> getFruits() {
		return fruitService.findAll();
	
	}
	
	@PostMapping(value = "/createFruit")
	public void createFruit(@RequestBody Fruit theFruit) {
		 fruitService.insertFruit(theFruit);
	
	}
	@PutMapping(value = "/updateFruit")
	public void updateFruit(@RequestBody Fruit theFruit) {
		 fruitService.updateFruit(theFruit);
	
	}
	@PutMapping(value = "/executeUpdateFruit")
	public void executeUpdateFruit(@RequestBody Fruit theFruit) {
		 fruitService.executeUpdateFruit(theFruit);
	
	}
	
	@DeleteMapping(value = "/deleteFruitByName")
	public void deleteFruit(@RequestBody Fruit theFruit) {
		 fruitService.deleteFruit(theFruit);
	
	}
	
	
}
