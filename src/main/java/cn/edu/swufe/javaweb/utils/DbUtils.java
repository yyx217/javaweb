package cn.edu.swufe.javaweb.utils;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtils {
private static BasicDataSource dataSource;
	
	static {		
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
		dataSource.setUrl("jdbc:mysql://192.168.48.84:3306/javaweb");
=======
		dataSource.setUrl("jdbc:mysql://192.168.48.84/javaweb");
>>>>>>> a669c582b784430f1b38a33091a49a766f98f3eb
		dataSource.setUsername("root");
		dataSource.setPassword("yyx191702");	
	}
	
	public static DataSource getDataSource() {
		
		return dataSource;
	}
}
