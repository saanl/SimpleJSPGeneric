package com.project.demo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MysqlConnection {
	private final static  String url="jdbc:mysql://127.0.0.1:3306/";
	private final static  String uname="root";
	private final static  String pwd="1234";
	private static Connection conn = null;
	
	private MysqlConnection() {}
	
	public static Connection getConnection(String db_name) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url+db_name, uname, pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	public static void closeConnection() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(getConnection("demo02"));
		closeConnection();
	}
}
