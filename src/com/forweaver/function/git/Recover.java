package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ResetCommand.ResetType;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class Recover extends BrowserFunction {
	public Recover(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "recover");
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		try {
			Repository localRepo = new FileRepository(Static.workspacePath + File.separatorChar + ".git");// 깃 저장소 불러오기
			Git git = new Git(localRepo); // 깃 관리 생성
			git.reset().setRef("HEAD").setMode(ResetType.HARD).call(); //작업내역을 최신 커밋으로 복구함
		} catch (Exception e) {
			CreateErrorWindow.open("에러", "작업을 복구하지 못하였습니다!");
			return false;
		}
		return true;

	}
}
