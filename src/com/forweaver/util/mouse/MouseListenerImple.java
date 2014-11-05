package com.forweaver.util.mouse;

import java.util.Stack;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.forweaver.util.Static;

public class MouseListenerImple implements MouseListener {
	
	Shell shell;
	
	public MouseListenerImple(Shell shell){
		this.shell = shell;
	}
	
	public void mouseUp(MouseEvent e) {
		// TODO Auto-generated method stub
		Static.origin = null;
	}
	
	public void mouseDown(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.x < shell.getSize().x - 40 && e.y <40){
			Static.origin = new Point(e.x, e.y);
			shell.setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_SIZEALL));
		}
	}
		
	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
