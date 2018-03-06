package com.project.pojo;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenericPOJO {
	
	private final static String CLASSTYPE = "class";
	
	public static void createPoJo(String tablename,Map<String ,String[]> map) {
		
		String className = stringUtil(tablename, CLASSTYPE);
		Map<String,String> MethodName = new LinkedHashMap<>();
		List<String> body = new ArrayList<>();
		body.add("package com.project.pojo;");
		body.add("public class "+className+"{");
		
		
		for(String set:map.keySet()) {		
			
			String[] s = map.get(set);
			
			if(s[0].equalsIgnoreCase("INT")) {
				MethodName.put(stringUtil(set, ""),"Integer");
			}else {
				MethodName.put(stringUtil(set, " "),"String");
			}
			
		}
		
		for(String set:MethodName.keySet()) {
			body.add("private "+MethodName.get(set)+" "+set+" ;");
		}
		for(String set:MethodName.keySet()) {
			body.add("public "+MethodName.get(set)+" get"+stringUtil(set, "class")+"() {return "+set+";}");	
			body.add("public void set"+stringUtil(set, "class")+"("+MethodName.get(set)+" "+set+") {this."+set+" = "+set+";}");	
		}
		body.add("}");
		
		save(className,body);
		
		System.out.println("pojo生成完毕");
	}
	
	
	public static void save(String className,List<String> body) {
		FileOutputStream fos = null;
		File f = new File("D://myproject/com/project/pojo");
		if(!f.exists()) {
			f.mkdirs();
		}
		try {
			fos = new FileOutputStream("D://myproject/com/project/pojo/"+className+".java");
			for(String s:body) {
				fos.write(s.getBytes());
				for (int i = 0; i < 3; i++) {
					fos.write("\r\n".getBytes());
				}	
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
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
				
			}
		}
			return str;
	}
	
	public static void main(String[] args) {
			System.out.println(stringUtil("wel_come_w",""));
	}
}
