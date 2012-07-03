package com.juapk.frame.cos;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 * 项目名称：juapk
 * 类名称：CosUtils
 * 类描述：COS 工具类 
 * 创建人：hubin
 * 创建时间：2012.03.10
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class CosUtils {
	
	/**
	 * 创建JUAPK上传文件路径：
	 * 	  			/res/uploads/ ... /0310
	 * @param request
	 * @param dirPath
	 */
	public void mkDir(HttpServletRequest request,String dirPath){
		Date date = new Date();//获取当前时间
		SimpleDateFormat sdfFolder = new SimpleDateFormat("yyMM");
		File fileDir = new File(request.getSession().getServletContext().getRealPath("/res/uploads/" + dirPath
				+"/"+sdfFolder.format(date)));
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
	}
	
}
