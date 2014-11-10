package com.forweaver.view;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.forweaver.function.git.ChangeBranch;
import com.forweaver.function.git.DeleteBranch;
import com.forweaver.function.git.DeleteCommit;
import com.forweaver.function.git.GitDownload;
import com.forweaver.function.git.GitInit;
import com.forweaver.function.git.LoadBranchList;
import com.forweaver.function.git.LoadCommitLogSimpleList;
import com.forweaver.function.git.Pull;
import com.forweaver.function.git.Push;
import com.forweaver.function.git.Recover;
import com.forweaver.function.project.AddProject;
import com.forweaver.function.project.DeleteProject;
import com.forweaver.function.project.GetSelectProjectName;
import com.forweaver.function.project.LoadProject;
import com.forweaver.function.util.InitStatic;
import com.forweaver.function.util.RememberSelectProject;
import com.forweaver.function.util.RememberWeaver;
import com.forweaver.function.window.CreateAlertWindow;
import com.forweaver.function.window.CreateBranchWindow;
import com.forweaver.function.window.CreateCommitLogWindow;
import com.forweaver.function.window.CreateCommitWindow;
import com.forweaver.function.window.CreateDirectoryWindow;
import com.forweaver.function.window.util.WindowCancel;
import com.forweaver.function.window.util.WindowExit;
import com.forweaver.function.window.util.WindowMinimize;
import com.forweaver.util.mouse.MouseListenerImple;
import com.forweaver.util.mouse.MouseMoveListenerImple;


public class MainWindow {

	protected Shell shell;
	protected Point origin;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.NO_TRIM);	
		shell.setSize(336, 486);
		shell.setText("위버네스트");	
		shell.setBackground(new Color(null, new RGB(60, 60, 60)));
		int x = ( Display.getDefault().getBounds().width - shell.getSize().x)/2;
		int y = ( Display.getDefault().getBounds().height - shell.getSize().y)/2;
		shell.setLocation (x, y);
       
		Browser browser = new Browser(shell, SWT.NONE);
		new RememberWeaver(browser);
		new RememberSelectProject(browser);
		new ChangeBranch(browser);
		new CreateCommitWindow(browser);
		new CreateBranchWindow(browser);
		new CreateAlertWindow(browser);
		new CreateCommitLogWindow(browser);
		new GitDownload(browser);
		new LoadProject(browser);
		new LoadBranchList(browser);
		new LoadCommitLogSimpleList(browser);
		new WindowCancel(browser);
		new WindowExit(browser);
		new WindowMinimize(browser);
		new Recover(browser);
		new DeleteCommit(browser);
		new DeleteBranch(browser);
		new Pull(browser);
		new Push(browser);
		new GetSelectProjectName(browser);
		new CreateDirectoryWindow(browser);
		new InitStatic(browser);
		new AddProject(browser);
		new DeleteProject(browser);
		new GitInit(browser);
		
		browser.setBounds(4, 4, 328, 478);
		browser.setUrl(MainWindow.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"html/front.html");
		browser.addMouseMoveListener(new MouseMoveListenerImple(shell));
		browser.addMouseListener(new MouseListenerImple(shell));
		
	}
}
