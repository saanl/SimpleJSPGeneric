package com.project.jsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenericJSP {
	
	
	private final static String[] crud = {"add.txt","add_.txt","update.txt","update_.txt",
			"delete.txt","list.txt","queryList.txt"};
	
	public static void createJSP(String tablename,String path,String zh) {
		
		for(String s:crud) {
			if(s.contains("_")) {
				String jsp = s.substring(0,s.indexOf("_"));
				save(tablename,s,jsp+stringUtil(tablename,"class"),path,zh);
			}else {
				save(tablename,s,s.substring(0,s.indexOf(".")),path,zh);
			}
		}
		System.out.println("jsp生成完毕");
	}
	public static void save(String tablename,String filename,String jspName,String path,String zh) {
		BufferedReader bu = null;
		FileWriter fr = null;
		tablename = stringUtil(tablename,"class");
		File f = new File("D://myproject/view/"+tablename);
		if(!f.exists()) {
			f.mkdirs();
		}
		try {
			fr = new FileWriter("D://myproject/view/"+tablename+"/"+jspName+".jsp");
			bu= new BufferedReader(new FileReader(path+filename));
			String s = null;
			while((s=bu.readLine())!=null) {
				if(s.contains("#")) {
					s = s.replace("#", tablename);
				}else if(s.contains("$$")){
					s = s.replace("$$", zh);
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
