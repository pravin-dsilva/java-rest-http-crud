package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Fruit;

public class FruitRowMapper implements RowMapper<Fruit> {

	@Override
	public Fruit mapRow(ResultSet rs, int arg1) throws SQLException {
		Fruit theFruit = new Fruit();
		theFruit.setFruitName(rs.getString("fruitName"));
		theFruit.setFruitQuantity(rs.getString("fruitQuantity"));
 
        return theFruit;
	}


}
