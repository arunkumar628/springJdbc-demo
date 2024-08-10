package com.spring.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.pojo.Student;

public class RowMapperImpl implements RowMapper<Student>
{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Student s=new Student();
		s.setId(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setFees(rs.getDouble(3));
		
		return s;
	}

}
