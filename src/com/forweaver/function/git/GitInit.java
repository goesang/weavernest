package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class GitInit extends BrowserFunction{

	public GitInit(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "gitInit");
	}
	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		File projectGit = new File(Static.selectProjectPath+File.separatorChar+".git");
		if(projectGit.exists())
			return true;
		try {
			Repository localRepo = new FileRepository(Static.selectProjectPath + File.separatorChar+".git");
			Git git = new Git(localRepo);
			git.init().setDirectory(new File(Static.selectProjectPath)).call();
			git.add().addFilepattern(".").call();
			git.commit().setMessage("위버네스트에 의해 초기화되었습니다!").call();
			Runtime.getRuntime().exec("attrib +H "+Static.selectProjectPath + File.separatorChar+".git");
		} catch (Exception e) {
			CreateErrorWindow.open("깃 초기화 에러", "깃을 초기화하지 못하였습니다!");
			return false;
		}
		return true;
	}
}
