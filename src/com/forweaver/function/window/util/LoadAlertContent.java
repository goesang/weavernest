package com.forweaver.function.window.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.Static;

public class LoadAlertContent  extends BrowserFunction{

	public LoadAlertContent(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "loadAlertContent");
	}
	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		return Static.alertContent;
	}
}
