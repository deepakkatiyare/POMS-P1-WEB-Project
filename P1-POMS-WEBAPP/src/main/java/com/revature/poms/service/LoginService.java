package com.revature.poms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.poms.config.DatabaseConnection;

public class LoginService {
	private static Connection conn;
	static {
		conn = DatabaseConnection.getConnection();;
	}
	public boolean  Login(String username,String password)
	{
		int record = -1;
		String query = "Select * from admin where username = ? and password = ?";
		try(PreparedStatement prStatement = conn.prepareStatement(query);
				){
			prStatement.setString(1, username);
			prStatement.setString(2, password);
			record = prStatement.executeUpdate();	
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(record>0)
			return true;
		else
			return false;
	}
	}

