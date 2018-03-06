package com.project.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.GenericDao;
import com.project.demo.GenericMysqlTable;
import com.project.jsp.GenericJSP;
import com.project.pojo.GenericPOJO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Main extends HttpServlet{
	private final String[] str = {"username","userpwd","dbname","tablename","primary","primary_type","primary_length"};
	private final String[] str1= {"attr_zn","attr_en","attr_type","attr_length"};
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String s = req.getParameter("json");
		String jsonstr = new String(s.getBytes("ISO8859-1"),"UTF-8");
		
		JSONObject json = JSONObject.fromObject(jsonstr);
		String uname = json.getString("username");
		String pwd = json.getString("userpwd");
		String dbname = json.getString("dbname");
		String tablename = json.getString("tablename");
		
		JSONArray arr0 = json.getJSONArray("attr_en");
		JSONArray arr1 = json.getJSONArray("attr_type");
		JSONArray arr2 = json.getJSONArray("attr_length");
		JSONArray arr3 = json.getJSONArray("attr_zn");//中文
		
		//System.out.println(arr3);
		
		
		
		Map<String,String[]> map = new LinkedHashMap<String,String[]>();
		//主键处理
				if(json.getString("primary_type").equals("int")) {
					map.put(json.getString("primary"), getStringArray("",true,true));
				}else {
					map.put(json.getString("primary"), getStringArray(json.getString("primary_length"),false,true));
				}
		//非主键处理
				List<String> list = new ArrayList<>();//获取中文，和英文属性对其
		for(int i=0;i<arr0.size();i++) {
			if(arr1.getString(i).equals("int")) {
				if(!arr0.getString(i).equals("")) {//去除空值
					list.add(arr3.getString(i));
					map.put(arr0.getString(i), getStringArray(arr2.getString(i),true,false));
				}		
			}else {
				if(!arr0.getString(i).equals("")) {
					list.add(arr3.getString(i));
					map.put(arr0.getString(i), getStringArray(arr2.getString(i),false,false));
				}
			}
		}
		
		
		//System.out.println(list);
		StringBuilder sb = new StringBuilder();
		sb.append("title.add(\"ID\");");
		for(String y:list) {
			sb.append("title.add(\""+y+"\");");//"\"file\"
		}
		//System.out.println(sb.toString());
		//System.out.println(map);
		createJSP(tablename,sb.toString());
		createPojo(tablename,map);
 		createDao(tablename,dbname,uname,pwd);
		setTable(tablename,map,dbname);
		resp.sendRedirect("success.jsp");
	}
	
	public void createDao(String tablename,String dbname,String uname,String pwd) {
		String path = this.getClass().getClassLoader().getResource("/MysqlConnection.txt").getPath();
		String path1 = this.getClass().getClassLoader().getResource("/template.txt").getPath();
		
		GenericDao.createDao(tablename, dbname,path1);
		GenericDao.createMysqlConnction(uname, pwd,path);
	}
	
	public void createJSP(String tablename,String zh) {
		String path =this.getClass().getClassLoader().getResource("//").getPath();
		GenericJSP.createJSP(tablename,path,zh);
	}
	
	public void createPojo(String tablename,Map<String,String[]> map) {
		GenericPOJO.createPoJo(tablename, map);	
	}
	
	public void setTable(String tablename,Map<String,String[]> map,String dbname) {
		GenericMysqlTable.setTable(tablename,map,dbname);
	}
	
	public final static String STR = "VARCHAR";
	public final static String INT = "INT";
	public static String[] getStringArray(String len,boolean isInt,boolean primary) {
		if(len==null||len.equals("")) {len="15";}
		if(primary) {
			if(isInt) {
				
				return new String[] {INT,"11","y","y","y"};
			}else {
				return new String[] {STR,len,"y","y","y"};
			}
		}else {
			if(isInt) {
				return new String[] {INT,"11","n","n","n"};
			}else {
				return new String[] {STR,len,"n","n","n"};
			}
		}
		
		
	}
	
}
