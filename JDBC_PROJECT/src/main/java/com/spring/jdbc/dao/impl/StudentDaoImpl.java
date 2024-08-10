package com.spring.jdbc.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.pojo.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String toString() {
		return "StudentDaoImpl [jdbcTemplate=" + jdbcTemplate + "]";
	}

	@Override
	public int insertStudent(Student s) 
	{
		String query="INSERT INTO STUDENT (id,name,fees) VALUES(?,?,?)";
		int insert= jdbcTemplate.update(query,s.getId(),s.getName(),s.getFees() );
		
		return insert;
	}

	@Override
	public int updateStudent(Student s) 
	{
		String query="UPDATE STUDENT SET NAME=?,FEES=? WHERE ID=?";
		int update = jdbcTemplate.update(query, s.getName(),s.getFees(),s.getId());
		
		return update;
	}

	@Override
	public int deleteStudent(int studentId) 
	{
		String query="DELETE FROM STUDENT WHERE ID=?";
		int delete = jdbcTemplate.update(query,studentId);
		return delete;
	}

	@Override
	public Student selectStudent(int studentId) 
	{
		RowMapper<Student> rowMapper=  new RowMapperImpl();
		
		String query="SELECT * FROM STUDENT WHERE ID=?";
		Student student = jdbcTemplate.queryForObject(query, rowMapper ,studentId);
		
		return student;
	}

	@Override
	public List<Student> selectAllStudent() {
		String query="SELECT * FROM STUDENT ";
		List<Student> student= jdbcTemplate.query(query, new RowMapperImpl());
		
		return student;
	}

}
