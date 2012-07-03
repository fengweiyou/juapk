package com.juapk.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juapk.frame.cos.RenamePolicyCos;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.ServletUtils;

/**
 * 项目名称：juapk
 * 类名称：CosController
 * 类描述：COS 文件上传下载组件业务处理类  
 * 创建人：hubin
 * 创建时间：2011.02.07
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class CosController extends BaseController{
	
	/**
	 * 文件上传
	 * @param request
	 * @param response
	 */
	@RequestMapping("/s/upload.do")
	public void uploadFile(HttpServletRequest request,HttpServletResponse response) {
		File fileDir = new File(request.getSession().getServletContext().getRealPath("/FileDir"));
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		// 设置上传文件的大小，超过这个大小 将抛出IOException异常，默认大小是1M。
		int inmaxPostSize = 10 * 1024 * 1024;
		MultipartRequest multirequest = null;
		// 上传文件重命名策略
		RenamePolicyCos myRenamePolicyCos = new RenamePolicyCos();
		try {
			// MultipartRequest()有8种构造函数！
			multirequest = new MultipartRequest(request, fileDir
					.getAbsolutePath(), inmaxPostSize, "GBK", myRenamePolicyCos); // GBK中文编码模式上传文件
			String subject = multirequest.getParameter("subject");// 获取普通信息
			System.out.println(subject);
			Enumeration<String> filedFileNames = multirequest.getFileNames();
			String filedName = null;
			if (null != filedFileNames) {
				while (filedFileNames.hasMoreElements()) {
					filedName = filedFileNames.nextElement();// 文件文本框的名称
					// 获取该文件框中上传的文件，即对应到上传到服务器中的文件
					File uploadFile = multirequest.getFile(filedName);
					if (null != uploadFile && uploadFile.length() > 0) {
						System.out.println(uploadFile.getName());
						System.out.println(uploadFile.getPath());
						System.out.println(uploadFile.length());
					}
					// 获取未重命名的文件名称
					String Originalname = multirequest.getOriginalFileName(filedName);
					System.out.println(Originalname);
				}
			}
		} catch (Exception e) {
			LOGGER.info("文件上传异常！" + e.getMessage());
		}
	}
	
	/**
	 * 文件下载
	 * @param request
	 * @param response
	 */
	@RequestMapping("/s/fileDownload.do")
	public void fileDownload(HttpServletRequest request,HttpServletResponse response) {
		String filePath = "E:\\java\\tomcat6.0\\webapps\\CosUpload\\FileDir\\";
		String fileName = "abc.txt";
		String Originalname = "2010年10月安排.txt";
		try {
			String isofilename = new String(Originalname.getBytes("gb2312"),
					"ISO8859-1");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ isofilename);
			ServletOutputStream out = null;
			out = response.getOutputStream();
			ServletUtils.returnFile(filePath + fileName, out);
			if (null != out) {
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}