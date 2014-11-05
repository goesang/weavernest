package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class CreateBranch extends BrowserFunction {
	public CreateBranch(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "createBranch");
	}
	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		String branchName = arguments[0].toString();
		
		try{
			Repository localRepo = new FileRepository(Static.selectProjectPath +File.separatorChar+ ".git"); // 깃 저장소를 가져온다.
			Git git = new Git(localRepo);
			git.branchCreate().setName(branchName).call();
			git.checkout().setName(branchName).call(); // 깃 브랜치를 바꿈
		}catch(Exception e){
			System.out.println(e.getMessage());
			CreateErrorWindow.open("에러", "브랜치를 생성하지 못하였습니다!");
			return false;
		}
	return true;
	}
}
