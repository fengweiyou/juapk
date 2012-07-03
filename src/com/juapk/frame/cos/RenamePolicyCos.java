package com.juapk.frame.cos;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.oreilly.servlet.multipart.FileRenamePolicy;

/**
 * 项目名称：juapk
 * 类名称：RenamePolicyCos
 * 类描述：文件命名策略 
 * 创建人：hubin
 * 创建时间：2011.02.07
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class RenamePolicyCos implements FileRenamePolicy {

	public File rename(File uploadFile) {
		String newName = getNewFileName(uploadFile.getName());
		File renameFile = new File(uploadFile.getParent(), newName);
		return renameFile;
	}

	private String getNewFileName(String fileName) {
		StringBuffer newName = new StringBuffer();
		if (null != fileName && !"".equals(fileName)) {
			String type = "";
			String name = "";
			if (fileName.indexOf(".") != -1) {
				type = fileName.substring(fileName.indexOf("."));
				name = fileName.substring(0, fileName.indexOf("."));
			}else{
				name = fileName;
			}
			newName.append(name);
			newName.append(getSuffix());
			newName.append(type);
		}
		return newName.toString();
	}
	
	
	private String getSuffix(){
		StringBuffer suffix = new StringBuffer("_");
		String now = new SimpleDateFormat("ddhhmmss").format(new Date());
		suffix.append(now);
		suffix.append("_");
		Random random = new Random();
		String randomValue = String.valueOf(random.nextInt(1000));
		suffix.append(randomValue);
		return suffix.toString();
	}

	/**
	 * 程序入口：用于测试
	 * @param args
	 */
	public static void main(String[] args) {
		RenamePolicyCos my = new RenamePolicyCos();
		System.out.println(my.getNewFileName("juapk.txt"));
	}

}