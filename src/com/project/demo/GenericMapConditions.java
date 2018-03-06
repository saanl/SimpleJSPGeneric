package com.project.demo;
import java.util.LinkedHashMap;
import java.util.Map;

import com.project.dao.GenericDao;
import com.project.jsp.GenericJSP;
import com.project.pojo.GenericPOJO;



public class GenericMapConditions {
	public final static String STR = "VARCHAR";
	public final static String INT = "INT";
	public final static String NOTNULL ="NOT NULL";
	public final static String AUTO = "AUTO_INCREMENT";//
	
	private Map<String,String[]> map = new LinkedHashMap<String,String[]>();
	//private String[] s= new String[5];//数据类型，长度，主键 ，非空，自增
	
	public Map<String,String[]> put(String key,String[] value) {
		if(key!=null&&!key.equals("")) {
			if(map.get(key)!=null) {
				throw new RuntimeException("key不能重复");
			};
		}
		map.put(key, value);
		return map;
	}
	
	public Map<String,String[]> getMap(){
		return map;
	};
	
	public static String[] getStringArray(String len,boolean isInt,boolean primary) {
		
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
	
	public static void main(String[] args) {
		GenericMapConditions g =new GenericMapConditions();
		
		
		g.put("id", getStringArray("",true,true));//主键
		g.put("name", getStringArray("10",false,false));
		g.put("sex", getStringArray("2",false,false));
		g.put("age", getStringArray("",true,false));
		g.put("myclass", getStringArray("12",false,false));
		
//		GenericMysqlTable.setTable("student",g.getMap());
//		
//		GenericPOJO.createPoJo("student", g.getMap());
//		
//		GenericDao.createDao("student", "demo02");
//		
//		GenericJSP.createJSP("student");
		
	}
}
