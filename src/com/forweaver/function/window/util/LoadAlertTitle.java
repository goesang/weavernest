package com.forweaver.function.window.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.Static;

public class LoadAlertTitle extends BrowserFunction{

	public LoadAlertTitle(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "loadAlertTitle");
	}
	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		return Static.alertTitle;
	}
}
