package com.main.start;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TestConnection {
	
	private final static  String url="jdbc:mysql://127.0.0.1:3306/";
	
	public static boolean isConnect(String uname,String pwd,String db_name) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url+db_name, uname, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(conn!=null) {
			return true;
		}
		
		return false;
	}
	
}
