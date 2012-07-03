package com.juapk.frame.helper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 项目名称：juapk
 * 类名称：ApplicationContextHelper
 * 类描述： 获得指定上下文和Root上下文环境
 * <p>
 * 通过在*.xml文件中配置
 * <pre>
 * &lt;bean id="applicationContextHelper"
 * class="com.juapk.frame.helper.ApplicationContextHelper"&gt;&lt;/bean&gt;
 * </pre>
 * 配置完成后ApplicationContextHelper会获得所在xml文件Context
 * 创建人：hubin
 * 创建时间：2011.03.15
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class ApplicationContextHelper implements ApplicationContextAware {
	
	private static ApplicationContext ctx = null;
	
	/**
	 * 获得Bean对象
	 * 
	 * @param object Bean类型
	 * @return Bean对象
	 */
	public static <T> T getBean(Class<T> object) {
		return ctx.getBean(object);
	}
	
	/**
	 * 获得Bean对象
	 * 
	 * @param className
	 * @return
	 */
	public static Object getBean(String className) {
		return ctx.getBean(className);
	}
	
	/**
	 * 获得应用所在上下文环境
	 * 
	 * @return
	 */
	public static ApplicationContext getContext() {
		return ctx;
	}

	/**
	 * (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware
	 * #setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext ac) throws BeansException {
		ctx = ac;
	}

}