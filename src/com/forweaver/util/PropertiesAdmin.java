package com.forweaver.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

public class PropertiesAdmin {
	private Properties pro;
	private  String filePath = this.getClass().getClassLoader().getResource("").getFile().substring(0)+"project.properties";
	
	public PropertiesAdmin(){	
		pro = new Properties();
	}
	public Set<Object> readProjectList(){

		String projectList = "[" ; //자바스크립트에 보낼 배열로 만듬
		try {
			pro.load(new InputStreamReader(new FileInputStream(filePath),	"UTF-8"));
			
			for (Object key:pro.keySet() ){				
				projectList += "['"+key.toString()+"',";
				projectList += "'"+pro.get(key)+"'],";
			}

		} catch (IOException e) {
			CreateErrorWindow.open("에러", "프로젝트 설정파일에 문제가 있습니다!");
		}
		
		if(projectList.length() == 1)
			projectList +="]";
		else
			projectList = projectList.substring(0, projectList.length() -1) +"]";
		
		return pro.keySet();
	}
	
	public Object get(String key){
		try {
			pro.load(new InputStreamReader(new FileInputStream(filePath),	"UTF-8"));
		} catch (IOException e) {
			CreateErrorWindow.open("에러", "프로젝트 설정파일에 문제가 있습니다!");
		}
		return pro.get(key);
	}
	
	public void delete(Object key){
		
		try {
			pro.remove(key);
			pro.save( new FileOutputStream(filePath),null);
		} catch (IOException e) {
			CreateErrorWindow.open("에러", "프로젝트 설정파일에 문제가 있습니다!");
		}
	}
	
	public void put(String key,String value){
		try {
			pro.put(key, value);
			pro.save( new FileOutputStream(filePath),null);
		} catch (IOException e) {
			CreateErrorWindow.open("에러", "프로젝트 설정파일에 문제가 있습니다!");
		}
		
	}
}
