package com.forweaver.function.project;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.PropertiesAdmin;
import com.forweaver.util.Static;

public class DeleteProject  extends BrowserFunction{

	public DeleteProject(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "deleteProject");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		String selectProject = arg[0].toString();	
		PropertiesAdmin pa = new PropertiesAdmin();
		
		if(pa.get(selectProject) != null){
			pa.delete(selectProject);
		}else{
			try{
				FileUtils.deleteDirectory(new File(Static.workspacePath+selectProject));
			}catch(Exception e){
				CreateErrorWindow.open("에러", "프로젝트를 삭제하지 못하였습니다!");
				return false;
			}
		}
		
		return true;
	}
}
