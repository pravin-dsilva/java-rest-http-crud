package io.openshift.booster.java_rest_http_crud.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import io.openshift.booster.java_rest_http_crud.entity.Fruit;
import io.openshift.booster.java_rest_http_crud.mapper.FruitRowMapper;

@Repository
public class FruitDaoImpl implements FruitDao {

	public FruitDaoImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	NamedParameterJdbcTemplate template;

	@Override
	public List<Fruit> findAll() {
		return template.query("select * from fruit", new FruitRowMapper());
	}

	@Override
	public Fruit findFruitById(String id) {
		final String sql = "select * from fruit where id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<Fruit> results = template.query(sql, param, new FruitRowMapper());
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}

	@Override
	public Fruit insertFruit(Fruit theFruit) {
		final String sql = "insert into fruit(id, name, quantity) values(:id,:name,:quantity)";
		UUID id = UUID.randomUUID();
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id.toString())
				.addValue("name", theFruit.getName()).addValue("quantity", theFruit.getQuantity());
		template.update(sql, param, holder);

		Fruit newFruit = findFruitById(id.toString());
		return newFruit;
	}

	@Override
	public Fruit updateFruit(String id, Fruit theFruit) throws IllegalArgumentException{
		Fruit currentFruit = findFruitById(id);

		if(currentFruit == null){
			throw new RuntimeException(String.format("Fruit with ID=%s not found.", id));
		}

		final String sql = "update fruit set name=:name, quantity=:quantity where id=:id";

		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id)
				.addValue("name", theFruit.getName()).addValue("quantity", theFruit.getQuantity());
		template.update(sql, param, holder);

		Fruit updatedFruit = findFruitById(id);
		return updatedFruit;

	}

	@Override
	public void deleteFruit(Fruit theFruit) {
		deleteFruit(theFruit.getId());
	}

	@Override
	public void deleteFruit(String id) {
		final String sql = "delete from fruit where id=:id";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);

		template.execute(sql, map, new PreparedStatementCallback<Object>() {
			@Override
			public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				return ps.executeUpdate();
			}
		});

	}

}
