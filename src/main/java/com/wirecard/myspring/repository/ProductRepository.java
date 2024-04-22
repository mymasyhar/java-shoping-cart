package com.wirecard.myspring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wirecard.myspring.domain.Product;

@Repository
public class ProductRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProductRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Product> findAll(){
		String sql = "SELECT * FROM products";
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		return products;
	}
	
	public Product findByCode(String code) {
		String sql = "SELECT * FROM products where code = ?";
		Product product = jdbcTemplate.queryForObject(sql, new Object[] {code}, new ProductMapper());
		return product;
	}
	
	private class ProductMapper implements RowMapper<Product>{

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
		    product.setCode(rs.getString("code"));
		    product.setName(rs.getString("name"));
		    product.setType(rs.getString("type"));
		    product.setPrice(rs.getInt("price"));
		    
			return product;
		}
		
	}
}
