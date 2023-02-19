package com.revature.poms.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnection {
	private static Connection connection = null;
	public static Connection getConnection() {
		if (connection == null) {
			String driver = "com.mysql.cj.jdbc.Driver";
			String dburl = "jdbc:mysql://localhost:3306/poms";
			String username = "root";
			String pass = "1401";
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(dburl, username, pass);
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return connection;
	}
}
