package com.project.demo;

import java.sql.SQLException;
import java.util.Map;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GenericMysqlTable {
	
	/*
	 CREATE TABLE `demo02`.`xx`(  
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR,		/* varchar数据类型的长度必须指定 */
 // PRIMARY KEY (`id`)
  	//) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci;
	
	public final static String STR = "VARCHAR";
	public final static String INT = "INT";
	public final static String NOTNULL ="NOT NULL";
	public final static String AUTO = "AUTO_INCREMENT";
	
	private static String prefix = "CREATE TABLE";
	private static String suffix = ")ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci;";
	
	public static String createSql(String tablename,Map<String ,String[]> map) {
		
		String myprefix = prefix+" "+tablename+"(";
				
		StringBuilder sb = new StringBuilder();
		String id = null;
		for(String set:map.keySet()) {
						
			String[] s = map.get(set);
			
			if(s[2].equals("y")) {
						//主键处理
						id = set;
						if(s[0].equalsIgnoreCase("varchar")) {
							sb.append(set+" "+s[0]+"("+s[1]+") "+NOTNULL+" ,");
						}else {
							sb.append(set+" "+s[0]+"("+s[1]+") "+NOTNULL+" "+AUTO+",");
						}
						
					}else {
						//非主键
						sb.append(set+" "+s[0]+"("+s[1]+") "+",");
					}
		
		}
				    sb.append("PRIMARY KEY ("+id+")");
		return myprefix+sb.toString()+suffix;
	}
	
	
	public static void setTable(String tablename,Map<String ,String[]> map,String dbname) {
		String creatsql = createSql(tablename,map);
		System.out.println(creatsql);
		Connection conn = MysqlConnection.getConnection(dbname);
		
		  try {
			Statement stmt = (Statement) conn.createStatement();
			stmt.execute(creatsql);
			System.out.println("表生成完毕");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MysqlConnection.closeConnection();
		}
	}
	
	public static void main(String[] args) {

	}
}
