package com.forweaver.function.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.Static;

public class RememberWeaver extends BrowserFunction {

	public RememberWeaver(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "rememberWeaver");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		Static.weaverName = arg[0].toString();
		Static.password = arg[1].toString();
			
		return true;
	}
}
