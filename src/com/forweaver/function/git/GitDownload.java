package com.forweaver.function.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;

import com.forweaver.util.CreateErrorWindow;
import com.forweaver.util.Static;

public class GitDownload extends BrowserFunction {

	public GitDownload(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "gitDownload");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		String treeURL = arg[0].toString();


		String localPath = Static.workspacePath;
		try {

			Repository localRepo = new FileRepository("/"+localPath + File.separatorChar+".git");
			Git git = new Git(localRepo);
				git.cloneRepository()
						.setDirectory(new File(localPath))
						.setURI(treeURL)
						.setCloneAllBranches(true).call();
			    for(Ref ref:localRepo.getAllRefs().values()){
			    	String branchName = ref.getName().substring(ref.getName().lastIndexOf("/")+1);
			    	git.branchCreate()
			    	.setName(branchName)
			    	.setStartPoint(ref.getName()).call();
			    	git.checkout().setName(branchName).call();
			    }
			    	

		} catch (Exception e) {
			System.out.println(e.getMessage());
			CreateErrorWindow.open("에러", "프로젝트를 다운로드하지 못하였습니다!");
			return false;
		}
		return true;

	}
}
