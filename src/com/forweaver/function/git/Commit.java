package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class Commit extends BrowserFunction {
	public Commit(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "commit");
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		String commitMessage = arguments[0].toString();
		boolean amend =arguments[1].equals("true");
		try {
			Repository localRepo = new FileRepository(Static.selectProjectPath
					+ File.separatorChar + ".git"); // 깃 저장소를 가져온다.
			Git git = new Git(localRepo);
			git.add().addFilepattern(".").call(); // 그냥 모든 파일을 추가함
			CommitCommand tmp = git.commit().setMessage(commitMessage).setAmend(amend);

			if(!Static.name.equals("") && !Static.email.equals(""))
				tmp.setAuthor(Static.name, Static.email);

			tmp.call(); // 커밋 로그 작성
			
			return true;
		} catch (Exception e) {
			CreateErrorWindow.open("에러", "커밋하지 못하였습니다!");
			return false;
		}

	}
}
