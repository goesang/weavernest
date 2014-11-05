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

public class DownloadTree extends BrowserFunction {

	public DownloadTree(Browser _browser) {
		// TODO Auto-generated constructor stub
		super(_browser, "downloadTree");
	}

	@Override
	public Object function(Object[] arg) {
		// TODO Auto-generated method stub
		Boolean isHomeWork = Boolean.valueOf(arg[0].toString());
		String treeURL = arg[1].toString();
		String treeName = arg[2].toString();


		String localPath = Static.workspacePath+treeName;
		try {

			Repository localRepo = new FileRepository("/"+localPath + File.separatorChar+".git");
			Git git = new Git(localRepo);
			if(isHomeWork){
			git.init()	.setDirectory(new File(localPath)).call();
			localRepo.getConfig().setString("remote", "origin", "url", treeURL);
			localRepo.getConfig().save();
			
			git.fetch().setRefSpecs(new RefSpec("refs/heads/"+treeName+"-master"))
					.setCredentialsProvider(
							new UsernamePasswordCredentialsProvider(Static.weaverName,
									Static.password)).call();
			git.checkout().setName("FETCH_HEAD").call(); // 걍 오류나서 이렇게 처리함.
			git.branchCreate().setName("master-"+Static.weaverName).call();
			git.checkout().setName("master-"+Static.weaverName).call();
			localRepo.getConfig().setString("remote", "origin", "url", treeURL.substring(0,treeURL.length()-11)+treeName+".git"); // 푸시 저장소 변경
			localRepo.getConfig().save();
			}
			else{
				git.cloneRepository()
						.setDirectory(new File(localPath))
						.setURI(treeURL)
						.setCloneAllBranches(true)
						.setCredentialsProvider(
								new UsernamePasswordCredentialsProvider(Static.weaverName,
										Static.password)).call();
			    for(Ref ref:localRepo.getAllRefs().values()){
			    	String branchName = ref.getName().substring(ref.getName().lastIndexOf("/")+1);
			    	git.branchCreate()
			    	.setName(branchName)
			    	.setStartPoint(ref.getName()).call();
			    	git.checkout().setName(branchName).call();
			    }
			    	
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			CreateErrorWindow.open("에러", "프로젝트를 다운로드하지 못하였습니다!");
			return false;
		}
		return true;

	}
}
