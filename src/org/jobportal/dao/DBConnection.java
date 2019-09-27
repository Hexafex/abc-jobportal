package org.jobportal.dao;

import java.sql.*;


public abstract class DBConnection {

public static Connection getConnection() throws SQLException{
	Connection con =null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/m5project?useSSL=false&serverTimezone=UTC","root","lithan");
		return con;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	
}
}
