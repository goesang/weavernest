package com.forweaver.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import com.forweaver.function.git.CreateBranch;
import com.forweaver.function.window.util.LoadAlertContent;
import com.forweaver.function.window.util.LoadAlertTitle;
import com.forweaver.function.window.util.WindowCancel;
import com.forweaver.util.mouse.MouseListenerImple;
import com.forweaver.util.mouse.MouseMoveListenerImple;
import com.forweaver.view.MainWindow;

public class CreateErrorWindow{

	protected static Point origin;
	
	public static void open(String title,String content){

		// TODO Auto-generated method stub
		if (Static.shell != null)
			Static.shell.dispose();
		
		Static.alertTitle = title;	
		Static.alertContent = content;		
		
		Static.shell = new Shell(SWT.NO_TRIM);
		Static.shell.setSize(370, 200);
		Static.shell.setText(Static.alertTitle);
		int x = ( Display.getDefault().getBounds().width - Static.shell.getSize().x)/2;
		int y = ( Display.getDefault().getBounds().height - Static.shell.getSize().y)/2;
		Static.shell.setLocation (x, y);
		Static.shell.setBackground(new Color(null, new RGB(60, 60, 60)));
		Browser browser = new Browser(Static.shell,  SWT.NONE);
		
		new WindowCancel(browser);
		new CreateBranch(browser);
		new LoadAlertContent(browser);
		new LoadAlertTitle(browser);
		
		browser.setBounds(4, 4, 362, 192);
		browser.setUrl(MainWindow.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"html/error.html");
		browser.addMouseMoveListener(new MouseMoveListenerImple(Static.shell));
		browser.addMouseListener(new MouseListenerImple(Static.shell));
		Static.shell.setVisible(true);
	}
}
