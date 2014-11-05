package com.forweaver.function.window.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class WindowMinimize extends BrowserFunction  {

	Browser browser;
	public WindowMinimize(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "windowMinimize");
		browser = _browser;
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		browser.getShell().setMinimized(true);
		return null;
	}

}
