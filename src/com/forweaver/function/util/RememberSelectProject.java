package com.forweaver.function.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.Static;

public class RememberSelectProject extends BrowserFunction  {

	public RememberSelectProject(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "rememberSelectProject");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		Static.selectProject = arg[0].toString();
		Static.selectProjectPath = arg[1].toString();
		
		return true;
	}

}
