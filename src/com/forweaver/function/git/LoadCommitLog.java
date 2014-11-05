package com.forweaver.function.git;

import java.io.ByteArrayOutputStream;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.gitective.core.CommitUtils;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;
import com.forweaver.util.WebUtil;

public class LoadCommitLog extends BrowserFunction {

	String commitID; 
	public LoadCommitLog(Browser _browser,String commitID) {
		// TODO Auto-generated constructor stub
		
		super(_browser, "loadCommitLog");
		this.commitID = commitID;
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		try {
			Repository localRepo = new FileRepository(
					Static.selectProjectPath + "/.git"); // 깃 저장소를 가져온다.
			Git git = new Git(localRepo); // 깃 저장소 객체 생성
			git = new Git(localRepo);
			RevCommit commit = CommitUtils.getCommit(localRepo, commitID);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			String diff = "";
			
			try {
				RevCommit preCommit = CommitUtils.getCommit(localRepo,	commitID + "~1");

				DiffFormatter df = new DiffFormatter(out);
				df.setRepository(localRepo);
				df.format(commit, preCommit);
				df.flush();
				df.release();
				diff = out.toString();

			} finally {
				String returnCommitLog="[";
				returnCommitLog += "'"+commit.getId().getName()+"',";
				returnCommitLog += "'"+commit.getShortMessage()+"',";
				returnCommitLog += "'"+commit.getCommitterIdent().getName()+"',";
				returnCommitLog += "'"+commit.getCommitterIdent().getEmailAddress()+"',";
				returnCommitLog += "'http://www.gravatar.com/avatar/"+WebUtil.convertMD5(commit.getCommitterIdent().getEmailAddress())+"?s=42',";
				returnCommitLog += "'"+WebUtil.intToTimeString(commit.getCommitTime())+"',";
				returnCommitLog += "\""+WebUtil.converter(diff)+"\"";
				returnCommitLog+="]";
				
				return returnCommitLog;
			}
			
			
			
		
		} catch (Exception e) {
			CreateErrorWindow.open("에러", "커밋을 로드하지 못하였습니다!");
			return "[]"; // 빈 배열을 보냄
		}
	}

}
