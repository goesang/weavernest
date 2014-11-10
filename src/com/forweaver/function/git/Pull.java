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

public class Pull extends BrowserFunction{

	public Pull(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "pull");
	}
	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub

		try {
			Repository localRepo = new FileRepository(Static.selectProjectPath + File.separatorChar+".git");
			Git git = new Git(localRepo);
			git.pull().call();

		} catch (Exception e) {
			CreateErrorWindow.open("에러", "풀하지 못하였습니다!");
			return false;
		}
		return true;
	}
}
