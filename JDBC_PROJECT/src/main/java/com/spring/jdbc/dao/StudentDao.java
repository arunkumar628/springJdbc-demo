package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.pojo.Student;

public interface StudentDao 
{
	public int insertStudent(Student s);
	public int updateStudent(Student s);
	public int deleteStudent(int studentId);
	public Student selectStudent(int studentId);
	public List<Student> selectAllStudent();
	

}
