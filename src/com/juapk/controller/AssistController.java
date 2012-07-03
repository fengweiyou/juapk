package com.juapk.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juapk.frame.GlobalConstants;
import com.juapk.frame.util.JsonUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 项目名称：juapk
 * 类名称：AssistController
 * 类描述：辅助业务处理类 
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:10:28
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
public class AssistController extends BaseController{
	
	/**
	 * 图片验证获取图片流
	 * @param Request
	 * @param Response
	 * @return
	 */
	@RequestMapping("/avoid/getVCode.do")
	public void getVCode(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result = new HashMap<String, Object>();
		String validateC = (String) request.getSession().getAttribute(GlobalConstants.VERIFYCODE);
		String veryCode = request.getParameter("c");
		if (veryCode == null || "".equals(veryCode)) {
			result.put("date", "0"); // 验证码为空
		} else {
			if (validateC.equals(veryCode)) {
				result.put("date", "1"); // 验证码正确
			} else {
				result.put("date", "2"); // 验证码错误
			}
		}
		// 返回JSON信息
		JsonUtils.responseAjaxRequest(response, JsonUtils.convertToJson(result));
	}
	
	/**
	 * 图片验证获取图片流
	 * @param Request
	 * @param Response
	 * @return
	 */
	@RequestMapping("/avoid/getValidateCode.do")
	public void getValidateCode(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		System.out.println("将删除存入SESSION认证码: "+session.getAttribute(GlobalConstants.VERIFYCODE));
		session.removeAttribute(GlobalConstants.VERIFYCODE);	// 删除 session 保存值
		response.setContentType("image/jpeg");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		// 在内存中创建图象
		// System.out.println("在内存中创建图象");
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height,
		BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		// System.out.println("获取图形上下文");
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		// 设定字体
		g.setFont(new Font("宋体", Font.BOLD, 18));
		// 随机产生3条(少量深色)干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(getRandColor(10, 50));
        for (int i = 0; i < 3; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(60);
            int yl = random.nextInt(20);
            g.drawLine(x, y, x + xl, y + yl);
        }
		// 取随机产生的认证码(4位数字)
		// System.out.println("取随机产生的认证码(4位数字");
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 
					+ random.nextInt(110))); // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 13 * i + 6, 16);
		}
		// 将认证码存入SESSION
		System.out.println("将认证码存入SESSION: "+sRand);
		session.setAttribute(GlobalConstants.VERIFYCODE, sRand); // 往  session 保存值 sRand
		// 图象生效
		g.dispose();
		// 输出图象到页面
		JPEGImageEncoder encoder;
		try {
			encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
			encoder.encode(image);
			response.getOutputStream().close();
		} catch (IOException e) {
			LOGGER.info("验证码图像输出流异常!");
		}
	}
	
	/**
	* 产生随机颜色对象
	* @param fc Unknown
	* @param bc Unknown
	* @return 随机产生的颜色对象
	*/
	private Color getRandColor(int fc, int bc) {
		// 给定范围获得随机颜色
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}