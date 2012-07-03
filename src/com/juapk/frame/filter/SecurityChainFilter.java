package com.juapk.frame.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：juapk
 * 类名称：DlFilter
 * 类描述：通过Filter 实现简单的防盗链
 * 创建人：HuBin
 * 创建时间：2012-5-26 上午8:58:06
 * 修改人：
 * 修改时间：2012-5-26 上午8:58:06
 * 修改备注：
 * @version V1.0
 */
public class SecurityChainFilter implements Filter {
    // 限制访问地址列表  
    public static List<String> urlNoAccess = new ArrayList<String>();
    // 允许访问列表  
    public static List<String> urlAllow = new ArrayList<String>();
    // 错误地址列表  
    public static String urlError = "";
    
    public void destroy() {
        // TODO Auto-generated method stub 
    }
  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub 
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // 获取HTTP头文件  
        String requestAddress = httpRequest.getRequestURL().toString();
        String requestHeader = httpRequest.getHeader("referer");
        
        if(!requestAddress.startsWith(urlError))
        {
            //循环止访问列表  
            for (int i = 0; i < urlNoAccess.size(); i++) {
                //如果(请求头为空 或者 请求头为禁访问目录)并且请求地址为禁止访问目录  
                //转向错误文件  
                if ((requestHeader == null || requestHeader.startsWith(urlNoAccess.get(i).toString().trim()))  
                        && requestAddress.startsWith(urlNoAccess.get(i).toString().trim())) {
                    if (urlError == null || urlError.equals("")) {
                        httpResponse.sendError(404);  
                    } else {
                        httpResponse.sendRedirect(urlError.trim());  
                    }
                    return;
                }
                //如果请求头为禁访问目录  
                if (requestAddress.startsWith(urlNoAccess.get(i).toString().trim())) {
                    boolean flog = true;
                    //如果请求头文件 不在允许请求范围内 
                    if (urlAllow != null && urlAllow.size() > 0) {
                        for (int j = 0; j < urlAllow.size() && flog; j++) {
                            if (requestHeader.startsWith(urlAllow.get(j).toString().trim())) {
                                flog = false;
                            }
                        }
                    }
                    if (!flog) {
                        if (urlError == null || urlError.equals("")) {
                            httpResponse.sendError(404);
                        } else {
                            httpResponse.sendRedirect(urlError.trim());
                        }
                        return;
                    }
                }
            }
        }
        chain.doFilter(httpRequest, httpResponse);
    }
  
    public void init(FilterConfig fc) throws ServletException {
        // TODO Auto-generated method stub  
        System.out.println("盗链起动");
        try {
            String fp = fc.getServletContext().getRealPath(
                    "/WEB-INF/classes/filter.properties");
            File file = new File(fp);
            Properties properties = new Properties();
            properties.load(new FileInputStream(file));
            // 限制访问地址 
            String urlfilter = properties.getProperty("url.noAccess");
            if (urlfilter != null) {
                String[] filter = urlfilter.split(",");
                for (int i = 0; i < filter.length; i++) {
                    urlNoAccess.add(((String)filter[i]).trim());
                }
            }
            // 根目录  
            String urlroot = properties.getProperty("url.allow");
            if (urlroot != null) {
                String[] allow = urlroot.split(",");
                for (int i = 0; i < allow.length; i++) {
                    urlAllow.add(((String)allow[i]).trim());
                }
            }
            // 文件错误地址 
            urlError = properties.getProperty("url.error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}