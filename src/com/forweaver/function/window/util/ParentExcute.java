package com.forweaver.function.window.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.Static;


public class ParentExcute extends BrowserFunction{

	private Browser parentBrowser;
	public ParentExcute(Browser _browser,Browser parentBrowser) {
		// TODO Auto-generated constructor stub
		super(_browser, "parentExcute");
		this.parentBrowser = parentBrowser;
	}
	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		String parentScript = arguments[0].toString();
		if(parentScript.length() == 0)
			this.parentBrowser.execute(Static.parentScript);
		else 
			this.parentBrowser.execute(parentScript);
		return true;
	}
}
