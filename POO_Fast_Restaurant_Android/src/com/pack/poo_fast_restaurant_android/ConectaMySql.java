package com.pack.poo_fast_restaurant_android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySql {

	private static final String URL = "jdbc:mysql://localhost/exemplows";
	private static final String USER = "root";
	private static final String SENHA = "";
	
	
	public static Connection obtemConexao() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, SENHA);
		
	}
	
}
