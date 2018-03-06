package com.project.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GenericDao {
	
	public static void main(String[] args) {
		//createDao("people","demo02");
		System.out.println("dao生成完毕");
	}
	public static void createDao(String tablename,String db_name,String path) {
		//createMysqlConnction();
		BufferedReader bu = null;
		FileWriter fr = null;
		tablename = stringUtil(tablename,"class");
		File f = new File("D://myproject/com/project/dao");
		if(!f.exists()) {
			f.mkdirs();
		}
		try {
			fr = new FileWriter("D://myproject/com/project/dao/"+tablename+"Dao.java");
			bu= new BufferedReader(new FileReader(path));
			String s = null;
			while((s=bu.readLine())!=null) {
				if(s.contains("#")) {
					s = s.replace("#", tablename);
				}else if(s.contains("@")) {
					s = s.replace("@", db_name);
				}
				fr.write(s);
				fr.write("\r\n");
			}
			System.out.println("dao生成完毕");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bu!=null) {
				try {
					bu.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void createMysqlConnction(String uname,String pwd,String path) {
		BufferedReader bu = null;
		FileWriter fr = null;
		File f = new File("D://myproject/com/project/dao");
		if(!f.exists()) {
			f.mkdirs();
		}
		try {
			fr = new FileWriter("D://myproject/com/project/dao/MysqlConnection.java");
			bu= new BufferedReader(new FileReader(path));
			String s = null;
			while((s=bu.readLine())!=null) {
				if(s.contains("#")) {
					s = s.replace("#", uname);
				}else if(s.contains("@")) {
					s = s.replace("@", pwd);
				}
				fr.write(s);
				fr.write("\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bu!=null) {
				try {
					bu.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
public static String stringUtil(String str,String type) {
		
		if(str!=null&&!str.equals("")) {
			
			if(type.equals("class")) {
				//如果作为类名
				String prefix = str.substring(0,1).toUpperCase();
				String suffix = str.substring(1,str.length());
				
				return prefix+suffix;
				
			}else {
				if(str.contains("_")) {
					//去掉下划线并且组成驼峰式
					String[] s=str.split("_");
					StringBuilder sb= new StringBuilder();
					sb.append(s[0]);
					for(int i =0 ;i<s.length;i++) {
						if(i>0) {
							String first = s[i].substring(0,1).toUpperCase();
							String suffix = s[i].substring(1,s[i].length());
							sb.append(first+suffix);
						}
					}
					
					return sb.toString();
					
				}else {
					
					return str;
					
				}
			}
			
			
		}else {
			
			System.out.println("名称不能为null以及空值");
			
		}
		
		return "";
	}
	
}
