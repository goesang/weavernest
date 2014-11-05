package com.forweaver.function.window;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.forweaver.function.git.Commit;
import com.forweaver.function.git.LoadCommitLog;
import com.forweaver.function.git.LoadHeadCommitMassage;
import com.forweaver.function.window.util.ParentExcute;
import com.forweaver.function.window.util.WindowCancel;
import com.forweaver.util.Static;
import com.forweaver.util.mouse.MouseListenerImple;
import com.forweaver.util.mouse.MouseMoveListenerImple;
import com.forweaver.view.MainWindow;

public class CreateCommitLogWindow extends BrowserFunction {
	Browser parentbrowser;
	protected Point origin;
	
	public CreateCommitLogWindow(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "createCommitLogWindow");
		parentbrowser = _browser;
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		if (Static.shell != null)
			return false;			
		Static.shell = new Shell(SWT.NO_TRIM);
		Static.shell.setSize(600, 540);
		Static.shell.setText("커밋 내역");
		int x = ( Display.getDefault().getBounds().width - Static.shell.getSize().x)/2;
		int y = ( Display.getDefault().getBounds().height - Static.shell.getSize().y)/2;
		Static.shell.setLocation (x, y);
		Static.shell.setBackground(new Color(null, new RGB(60, 60, 60)));
		Browser browser = new Browser(Static.shell,  SWT.NONE);
		//new LoadCommitLog(browser,arguments[0].toString());
		new WindowCancel(browser);
		
		browser.setBounds(4, 4, 592, 532);
		browser.setUrl(MainWindow.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"html/commitLog.html");
		browser.addMouseMoveListener(new MouseMoveListenerImple(Static.shell));
		browser.addMouseListener(new MouseListenerImple(Static.shell));
		Static.shell.setVisible(true);
		return true;
	}
}
