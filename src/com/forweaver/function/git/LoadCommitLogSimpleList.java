package com.forweaver.function.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class LoadCommitLogSimpleList extends BrowserFunction {

	public LoadCommitLogSimpleList(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "loadCommitLogSimpleList");
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		try {
			Repository localRepo = new FileRepository(Static.selectProjectPath + "/.git"); // 깃 저장소를 가져온다.
			Git git = new Git(localRepo); // 깃 저장소 객체 생성
			git = new Git(localRepo);
			String logList = "[";
			for (RevCommit rev : git.log().call()) {
				logList += "[\""+rev.getShortMessage()+"\",";
				logList += "\""+rev.getName()+"\"] ,";
			}
			logList = logList.substring(0, logList.length() - 1) + "]";
			
			if(logList.length() <=1) // 로그가 없을때
				return "[]"; // 빈 배열을 보냄
			
			return logList;
			
		} catch (Exception e) {
			CreateErrorWindow.open("에러", "커밋을 로드하지 못하였습니다!");
			return "[]"; // 빈 배열을 보냄
		}
	}

}
