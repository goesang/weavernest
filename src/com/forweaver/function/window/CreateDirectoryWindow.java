package com.forweaver.function.window;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.widgets.DirectoryDialog;


public class CreateDirectoryWindow extends BrowserFunction {

	public CreateDirectoryWindow(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "createDirectoryWindow");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		DirectoryDialog dlg = new DirectoryDialog(super.getBrowser().getShell());
        dlg.setText("프로젝트 불러오기 창");
        dlg.setMessage("프로젝트를 찾아보세요!");

		return  dlg.open();
	}
}
