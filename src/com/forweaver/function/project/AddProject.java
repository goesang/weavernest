package com.forweaver.function.project;

import java.io.File;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.PropertiesAdmin;
import com.forweaver.util.Static;

public class AddProject extends BrowserFunction{

	public AddProject(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "addProject");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		String selectProjectPath = arg[0].toString();
		String selectProject = selectProjectPath.substring(selectProjectPath.lastIndexOf("\\")+1);

		selectProjectPath= selectProjectPath.substring(0, 1)+":"+ selectProjectPath.substring(2,selectProjectPath.length());
		selectProjectPath = selectProjectPath.replaceAll("\\\\", "/");

		PropertiesAdmin pa = new PropertiesAdmin();
		
		if(pa.get(selectProject) == null){
			pa.put(selectProject, selectProjectPath);
			return true;
		}
		return false;
	}
}
