package com.juapk.frame.exception;

import java.util.Map;

/**
 * 项目名称：juapk
 * 类名称：BaseException
 * 类描述：应用级别的异常 
 * 创建人：hubin
 * 创建时间：2012.01.16
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class BaseException extends Exception {
	/** serialVersionUID 序列化时为了保持版本的兼容性 */
	private static final long serialVersionUID = -6699189172335435303L;

	/**MMT的错误编码*/
	private String errorcode;

	/**错误出现时的上下文*/
	private Map context;

	/**是否被记录的标志0表示未被标记*/
	private int flag = 0;

	/**
	 * 构造函数
	 * @param errorCode 错误编码
	 * @author Zhaosy 手工抛出异常重载构造
	 */
	public BaseException(String errorCode) {
		this.errorcode = errorCode;
	}

	/**
	 * 
	 * @param errorCode
	 * @param ex
	 */
	public BaseException(String errorCode, Throwable ex) {
		super("", ex);
		this.errorcode = errorCode;
	}

	/**
	 * 
	 * @param errorCode
	 
	 * @param context
	 * @param ex
	 */
	public BaseException(String errorCode, Map context, Throwable ex) {
		super("", ex);
		this.errorcode = errorCode;

		this.context = context;

	}

	/**
	 * @return Returns the context.
	 */
	public Map getContext() {
		return context;
	}

	/**
	 * @param context The context to set.
	 */
	public void setContext(Map context) {
		this.context = context;
	}

	/**
	 * @return Returns the errorcode.
	 */
	public String getErrorcode() {
		return errorcode;
	}

	/**
	 * @return Returns the flag.
	 */
	public int getFlag() {
		return flag;
	}

	/**
	 * @param flag The flag to set.
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
