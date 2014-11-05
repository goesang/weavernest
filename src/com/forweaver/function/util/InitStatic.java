package com.forweaver.function.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.widgets.Shell;

import com.forweaver.util.Static;

public class InitStatic extends BrowserFunction{

	public InitStatic(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "initStatic");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		Static.workspacePath = "/"+this.getClass().getClassLoader().getResource("").getFile().substring(1)+"workspace/";
		Static.selectProject = "";
		Static.selectProjectPath = "";
		Static.shell = null;
		Static.alertTitle = "";
		Static.alertContent = "";
		Static.parentScript = "";
		
		return true;
	}
}
