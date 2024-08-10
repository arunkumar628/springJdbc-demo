package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.pojo","com.spring.jdbc.dao.impl"})
//we can use array to get access for multiple names
//we can just declare the base package com.spring.jdbc to scan all the components too
public class jdbcConfig 
{
	@Bean(name= {"ds"})
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("ARUN");
		ds.setPassword("ORACLE");
		
		return ds;
	}

	@Bean({"jdbcTemplate","temp"})
	public JdbcTemplate getJdbcTemplate() 
	{
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
	
	
}
