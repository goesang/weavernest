package com.forweaver.function.project;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.Static;

public class GetSelectProjectName extends BrowserFunction{

	public GetSelectProjectName(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "getSelectProjectName");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		return Static.selectProject;
	}
}
