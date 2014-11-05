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

public class ChangeBranch extends BrowserFunction {
	public ChangeBranch(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "changeBranch");
	}
	
	@Override
	public Object function(Object[] args) {
	// TODO Auto-generated method stub
		String changeBranch = args[0].toString(); // 바꿀 브랜치 이름
		  try{
			   Repository localRepo = new FileRepository(Static.selectProjectPath+File.separatorChar+ ".git");// 깃 저장소 불러오기
		     Git git = new Git(localRepo); // 깃 관리 생성
		     git.reset().setRef("HEAD").setMode(ResetType.HARD).call();
		     git.checkout().setName(changeBranch).call(); // 깃 브랜치를 바꿈
			}catch(Exception e){
				CreateErrorWindow.open("에러", "브랜치를 바꾸지 못하였습니다!");
				return false;
			}
				return true;
		   }
	}