package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand.ResetType;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.Static;

public class DeleteCommit  extends BrowserFunction {
	public DeleteCommit(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "deleteCommit");
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		try{
			Repository localRepo = new FileRepository(Static.selectProjectPath +File.separatorChar+".git"); // 깃 저장소를 가져온다.
			Git git = new Git(localRepo);
			git.reset().setRef("HEAD^1").setMode(ResetType.HARD).call();
			git.clean().setCleanDirectories(true).call();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	return true;

	}
}
