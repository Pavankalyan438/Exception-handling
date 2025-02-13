package com.example.Exception_Training.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.Exception_Training.dao.Cricketers;

@Repository
public class JdbcCricketerRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Cricketers> findCricketersWithSalaryAbove(int salary, String firstname) {
		
		String sql = "SELECT * FROM cricketers WHERE salary > ? and firstname=?";
        return jdbcTemplate.query(sql, cricketersRowMapper(),new Object[]{salary, firstname});
    }

    private RowMapper<Cricketers> cricketersRowMapper() {
        return (rs, rowNum) -> {
        	System.out.println(rs+" "+"row Number:"+rowNum);
            Cricketers cricketers = new Cricketers();
            cricketers.setId(rs.getInt(1));
            cricketers.setFirstName(rs.getString(2));
            cricketers.setLastName(rs.getString(3));
            cricketers.setAge(rs.getInt(4));
            cricketers.setSalary(rs.getInt(5));
            cricketers.setLocation(rs.getString(6));
            return cricketers;
        };
    }

}
