package com.sample.postgress.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.Fruit;
import com.sample.postgress.mapper.FruitRowMapper;
@Repository
public class FruitDaoImpl implements FruitDao{
	
	public FruitDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
}  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Fruit> findAll() {
		return template.query("select * from fruit", new FruitRowMapper());
	}
	@Override
	public void insertFruit(Fruit theFruit) {
		 final String sql = "insert into fruit(fruitName, fruitQuantity) values(:fruitName,:fruitQuantity)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("fruitName", theFruit.getFruitName())
					.addValue("fruitQuantity", theFruit.getFruitQuantity());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void updateFruit(Fruit theFruit) {
		 final String sql = "update fruit set fruitName=:fruitName, fruitQuantity=:fruitQuantity where fruitName=:fruitName";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("fruitName", theFruit.getFruitName())
					.addValue("fruitQuantity", theFruit.getFruitQuantity());
	        template.update(sql,param, holder);
	 
	}
	
	@Override
	public void executeUpdateFruit(Fruit theFruit) {
 		 final String sql = "update fruit set fruitName=:fruitName, fruitQuantity=:fruitQuantity where fruitName=:fruitName";
	
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("fruitName", theFruit.getFruitName());
		 map.put("fruitQuantity", theFruit.getFruitQuantity());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
	@Override
	public void deleteFruit(Fruit theFruit) {
		 final String sql = "delete from fruit where fruitName=:fruitName";
			 

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("fruitName", theFruit.getFruitName());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  

	 
	}
	
}
