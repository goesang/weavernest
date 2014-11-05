package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.gitective.core.CommitUtils;

import com.forweaver.util.Static;

public class LoadHeadCommitMassage extends BrowserFunction {

	public LoadHeadCommitMassage(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "loadHeadCommitMassage");
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		try{
			Repository repo = new FileRepository(Static.selectProjectPath + File.separatorChar + ".git");
			RevCommit latestCommit = CommitUtils.getHead(repo);
			return latestCommit.getShortMessage();
		}catch(Exception e){
			return ""; // 특별한 오류 메세지는 띄우지 않고 빈 문자열을 보내 커밋(amend 없이) 커밋하게 함!
		}
		
	}
}
