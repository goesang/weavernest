package com.forweaver.util.drop;

import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;

public class DropTargetAdapterImple extends DropTargetAdapter{
	@Override
	public void drop(DropTargetEvent event) {
		// TODO Auto-generated method stub
		//텍스트 트렌스퍼 인지 검사후 셋팅  
        if(TextTransfer.getInstance().isSupportedType(event.currentDataType)){  
           System.out.println("이것은 텍스트");  
        } 
        //파일 트렌스퍼인지 검
        if(FileTransfer.getInstance().isSupportedType(event.currentDataType)){  
            boolean check=true;  
            for(String filePath:(String[])event.data){                                        
                if(check){  
                    System.out.println(filePath);
                    check=false;  
                    continue;  
                }  
                
            }  
              
        }  

	}
}
