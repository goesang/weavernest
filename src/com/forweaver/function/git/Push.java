package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class Push extends BrowserFunction{

	public Push(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "push");
	}
	@Override
	public Object function(Object[] arguments) {
		try {
			Repository localRepo = new FileRepository(Static.selectProjectPath +File.separatorChar+ ".git");
			Git git = new Git(localRepo);
			git.push()
					.setRemote("origin").call();

		} catch (Exception e) {
			CreateErrorWindow.open("에러", "푸시하지 못하였습니다!");
			return false;
		}
		return true;
	}
}
