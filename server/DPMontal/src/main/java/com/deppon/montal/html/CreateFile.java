/**
 * 
 */
package com.deppon.montal.html;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * 创建文件html(已作废)
 * @author Administrator
 *
 */
public class CreateFile {

	
	public void createNewFile(StringBuilder sb,int dataType,String realPath){
		
		if(realPath == null)
			realPath = "";
		
		String stri = sb.toString();
		String newName = String.valueOf(dataType);
		
		StringBuilder path = new StringBuilder();
				
		path.append(realPath ).append("upload").append(File.separator).append("mainFile");
		
		File file = new File(path.toString());
		if(!file.exists()){
			file.mkdirs();
		}
		
		file = new File(path.append(File.separator).append(newName+".html").toString());
		Charset charset = Charset.forName("UTF-8");
		
		OutputStreamWriter out = null;
		try{
			file.createNewFile();
			out = new OutputStreamWriter(new FileOutputStream(file),charset);
			out.write(stri);
			
		}catch(IOException ie){
			ie.printStackTrace();
		}finally{
			//printStream.close();
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void createNewFile(String htmlStr,String fileName,String realPath){
		if(realPath == null)
			realPath = "";
		
		StringBuilder path = new StringBuilder();
		
		path.append(realPath);
		
		File file = new File(path.toString());
		if(!file.exists()){
			file.mkdirs();
		}
		
		file = new File(path.append(File.separator).append(fileName).toString());
		Charset charset = Charset.forName("UTF-8");
				
		OutputStreamWriter out = null;
		try{
			
			file.createNewFile();
			out = new OutputStreamWriter(new FileOutputStream(file),charset);
			out.write(htmlStr);
			
		}catch(IOException ie){
			ie.printStackTrace();
		}finally{
			//printStream.close();
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] agrs){
		
		
	}
}
