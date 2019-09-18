package io.openshift.booster.java_rest_http_crud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.openshift.booster.java_rest_http_crud.entity.Fruit;
import io.openshift.booster.java_rest_http_crud.service.FruitService;

@RestController
@RequestMapping("/api")
public class ApplicationController {

	@Resource
	FruitService fruitService;

	@GetMapping(value = "/fruits")
	public List<Fruit> getFruits() {
		return fruitService.findAll();
	}

	@GetMapping(value = "/fruits/{id}")
	public Fruit getFruit(@PathVariable String id) {
		return fruitService.findById(id);
	}

	@PostMapping(value = "/fruits")
	public Fruit createFruit(@RequestBody Fruit theFruit) {
		return fruitService.insertFruit(theFruit);

	}

	@PutMapping(value = "/fruits/{id}")
	public Fruit updateFruit(@RequestBody Fruit theFruit, @PathVariable String id) throws IllegalArgumentException {
		return fruitService.updateFruit(id, theFruit);
	}

	@DeleteMapping(value = "/fruits/{id}")
	public void deleteFruit(@PathVariable String id) {
		fruitService.deleteFruit(id);
	}

}
