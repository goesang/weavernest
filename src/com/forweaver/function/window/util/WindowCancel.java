package com.forweaver.function.window.util;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.Static;

public class WindowCancel extends BrowserFunction  {

	public WindowCancel(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "windowCancel");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		Static.shell.dispose();
		Static.shell = null;
		return true;
	}

}
