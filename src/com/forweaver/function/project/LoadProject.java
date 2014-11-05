package com.forweaver.function.project;

import java.io.File;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.PropertiesAdmin;
import com.forweaver.util.Static;

public class LoadProject extends BrowserFunction{

	public LoadProject(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "loadProject");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		PropertiesAdmin pa = new PropertiesAdmin();
		String projectList= "[";
		File work = new File(Static.workspacePath);
		
		if(!work.exists()){
			return "[]";
		}
			
		for(File file : work.listFiles()){
			if(file.isDirectory()){
				projectList += "[\""+file.getName()+"\",";
				projectList += "\""+Static.workspacePath + file.getName()+"\"],";
			}
		}
		for (Object key:pa.readProjectList() ){				
			projectList += "[\""+key.toString()+"\",";
			projectList += "\""+pa.get(key.toString())+"\"],";
		}
		
		if(projectList.length() == 1)
			return projectList+="]";
		else
			return projectList.substring(0, projectList.length()-1)+"]";
	}
}
