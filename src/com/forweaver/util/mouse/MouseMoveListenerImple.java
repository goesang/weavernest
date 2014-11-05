package com.forweaver.util.mouse;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.forweaver.util.Static;

public class MouseMoveListenerImple implements MouseMoveListener {
	
	Shell shell;
	
	public MouseMoveListenerImple(Shell shell){
		this.shell = shell;
	}
	@Override
	public void mouseMove(MouseEvent e) {
		// TODO Auto-generated method stub

		if (Static.origin != null) {
			Point p = Display.getDefault().map(shell, null, e.x, e.y);
			shell.setLocation(p.x - Static.origin.x, p.y - Static.origin.y);
			
            }

		shell.setCursor(new Cursor(Display.getDefault(), SWT.CURSOR_ARROW));
	}
}
