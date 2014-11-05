package com.forweaver.function.window.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

public class WindowExit extends BrowserFunction {
	public WindowExit(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "windowExit");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		System.exit(0);
		return null;
	}
}
