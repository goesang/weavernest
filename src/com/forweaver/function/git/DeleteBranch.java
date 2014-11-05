package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class DeleteBranch extends BrowserFunction {
	public DeleteBranch(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "deleteBranch");
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		String branchName = arguments[0].toString();
		try {
			Repository localRepo = new FileRepository(Static.selectProjectPath
					+ File.separatorChar + ".git"); // 깃 저장소를 가져온다.
			Git git = new Git(localRepo);

			if (git.branchList().call().size() == 0) { // 만일 브랜치가 하나도 없다면
				CreateErrorWindow.open("브랜치 삭제 에러", "삭제할 브렌치가 없습니다!");
				return false;
			} else if (branchName.equals("master")) { // 마스터 삭제 불가
				CreateErrorWindow.open("브랜치 삭제 에러", "마스터 브렌치는 삭제할 수 없습니다!");
				return false;
			}
			git.checkout().setName("master").call();
			git.branchDelete().setBranchNames(branchName).setForce(true).call();
			return true;
		} catch (Exception e) {
			CreateErrorWindow.open("브랜치 삭제 에러", "브랜치를 삭제하지 못하였습니다!");
			return false;
		}

	}
}
