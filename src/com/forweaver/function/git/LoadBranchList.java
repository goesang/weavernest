package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class LoadBranchList extends BrowserFunction {

	public LoadBranchList(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "loadBranchList");
	}

	@Override
	public Object function(Object[] arguments) {
		// TODO Auto-generated method stub
		try {
			Repository localRepo = new FileRepository(Static.selectProjectPath
					+ File.separatorChar + ".git"); // 깃 저장소를 가져온다.
			Git git = new Git(localRepo); // 깃 저장소 객체 생성
			String branchNameList = "["; // 브랜치 이름 배열
			String checkOutBranch = localRepo.getBranch(); // 현재 체크아웃한 브랜치 이름

			if (git.branchList().call().size() == 0) { // 만일 브랜치가 하나도 없다면
				return "[[],\"\"]"; // 빈 배열과 빈 문자열을 보낸다.
			}

			for (Ref ref : git.branchList().call()) { // 브랜치들을 갖고 온다.
				String refName = ref.getName(); // 브랜치 주소를 갖고옴
				int branch = refName.lastIndexOf("/");
				String branchName = refName.substring(branch + 1); // 이름만 추려냄
				if (branchName.equals("HEAD"))
					continue;
				branchNameList += "\"" + branchName + "\","; // "브랜치 이름",으로 배열을 만듬
			}

			branchNameList = branchNameList.substring(0,
					branchNameList.length() - 1)
					+ "]"; // 배열 완성
			return "[" + branchNameList + ",\"" + checkOutBranch + "\"]";
			// 브랜치 이름 배열과 체크아웃한 브랜치 이름을 보낸다.

		} catch (Exception e) {// 오류 발생시 대충 처리
			CreateErrorWindow.open("에러", "브랜치을 로드하지 못하였습니다!");
			return "[[],\"\"]"; // 빈 배열과 빈 문자열을 보낸다.
		}
	}
}
