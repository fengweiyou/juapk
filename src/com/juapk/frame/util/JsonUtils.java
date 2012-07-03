package com.juapk.frame.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;

import com.juapk.frame.common.PageModel;

/**
 * JSON 工具类
 * @author HUBIN
 * @version 1.0
 * @since 2011-11-29
 */
public final class JsonUtils {

	public JsonUtils() {
	}

	/**
	 * Map<String, Object> 转为 String 格式
	 * @param result
	 * @return String
	 */
	public static String convertToJson(Map<String, Object> result) {
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(java.util.Date.class,new JsonValueProcessorImpl());
		config.registerJsonValueProcessor(java.sql.Date.class,new JsonValueProcessorImpl());
		JSONObject json = JSONObject.fromObject(result, config);
		return json.toString();
	}
	
	/**
	 * PageModel 转为 String 格式
	 * @param pm
	 * @return String
	 */
	public static String convertToJson(PageModel pm) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("offset", pm.getOffset());
		result.put("pageSize", pm.getPageSize());
		result.put("count", pm.getCount());
		result.put("data", pm.getData());
		return convertToJson(result);
	}

	/**
	 * Object 转为 String 格式
	 * @param obj
	 * @return String
	 */
	public static String convertToJson(Object obj){
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(java.util.Date.class,new JsonValueProcessorImpl());
		config.registerJsonValueProcessor(java.sql.Date.class,new JsonValueProcessorImpl());
		JSONObject json = JSONObject.fromObject(obj, config);
		return json.toString();
	}
	
	/**
	 * List<?> 转为 String 格式
	 * @param list
	 * @return String
	 */
	public static String convertToJson(List<?> list) {
		return JSONArray.fromObject(list).toString();
	}
	
	/**
	 * JSONObject 转为 MAP 格式
	 * @param json
	 * @return Map<String,Object>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> jsonToMap(JSONObject json){
		return (Map<String, Object>) JSONObject.toBean(json);
	}

	/**
	 * HttpServletResponse 返回请求流 
	 * @param response
	 * 			HttpServletResponse 响应
	 * @param resultStr
	 * 			JSON 格式字符串
	 */
	public static void responseAjaxRequest(HttpServletResponse response,
			String resultStr) {
		response.setContentType("text/txt;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(resultStr);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得field的getter函数名称.
	 * @param type
	 * @param fieldName
	 * 				字段名
	 */
	@SuppressWarnings("unchecked")
	private static String getGetterName(Class type, String fieldName) {
		return "get" + StringUtils.capitalize(fieldName);
	}

	/**
	 * 获得field的getter函数,如果找不到该方法,返回null.
	 * @param type
	 * @param fieldName
	 * 				字段名
	 */
	@SuppressWarnings("unchecked")
	private static Method getGetterMethod(Class type, String fieldName) {
		try {
			String methodName = getGetterName(type, fieldName);
			return type.getMethod(methodName, null);
		} catch (NoSuchMethodException e) {
		}

		return null;
	}

	/**
	 * 把用户指定的类转换成json字符串
	 * @param obj
	 * 				用户指定的转换类 @return json的字符串
	 * @return String
	 * 				字符串
	 */
	public static String toJsonString(Object obj) {
		if (obj == null)
			return "";

		StringBuffer buffer = new StringBuffer("");

		final Object tempObj = obj;
		List<?> array = getDeclaredFields(obj);
		boolean haveData = false;

		buffer.append("{");
		Object strValue = null;
		Field fld = null;

		try {
			for (int i = 0; i < array.size(); i++) {
				haveData = true;
				fld = (Field) array.get(i);
				String strFieldName = fld.getName();
				Method method = getGetterMethod(tempObj.getClass(), fld
						.getName());

				strValue = null;
				if (method != null) {
					try {
						strValue = method.invoke(tempObj, null);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}

				if (strValue == null) {
					strValue = "";
				}

				buffer.append("");
				buffer.append(strFieldName);
				buffer.append(":'");
				buffer.append(strValue.toString());
				buffer.append("',");
			}
		} catch (IllegalArgumentException ex) {
		}

		if (haveData) {
			buffer = new StringBuffer(
					(buffer.substring(0, buffer.length() - 1))).append("}");
		} else {
			buffer.append("}");
		}

		return buffer.toString();
	}

	/**
	 * 循环向上转型,获取对象的DeclaredFields.
	 * @param obj
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	private static List getDeclaredFields(final Object obj)
			throws SecurityException {
		List array = new ArrayList();

		for (Class superClass = obj.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			Field fds[] = superClass.getDeclaredFields();
			for (int i = 0; i < fds.length; i++) {
				array.add(fds[i]);
			}
		}

		return array;
	}

	/**
	 * 把用户指定的对象列表转换成jsonarray.
	 * 
	 * @param objectLst
	 *            用户指定的对象列表
	 * @return json的Array字符串
	 */
	@SuppressWarnings("unchecked")
	public static String toJsonArray(final List objectLst) {
		if (objectLst == null)
			return "[]";

		final List array = new ArrayList(objectLst);
		StringBuffer buffer = new StringBuffer("");
		boolean haveData = false;
		buffer.append("[");

		for (int i = 0; i < array.size(); i++) {
			haveData = true;
			buffer.append(toJsonString(array.get(i)));
			buffer.append(",");
		}

		if (haveData) {
			buffer = new StringBuffer(
					(buffer.substring(0, buffer.length() - 1))).append("]");
		} else {
			buffer.append("]");
		}

		return buffer.toString();
	}

	/**
	 * 以UTF-8的字符编码，在用户指定的OutputStream中写入Json字符串
	 * 
	 * @param os
	 *            输出流
	 * @param sendBody
	 *            用户指定的输出文本
	 */
	public static void sendJsonText(final OutputStream os, String sendBody) {
		sendJsonText(os, sendBody, "UTF-8");
	}

	/**
	 * 以encoding的字符编码，在用户指定的OutputStream中写入Json字符串
	 * 
	 * @param os
	 *            输出流
	 * @param sendBody
	 *            用户指定的输出文本
	 * @param encoding
	 *            用户指定的编码集
	 */
	public static void sendJsonText(final OutputStream os, String sendBody,
			String encoding) {
		try {
			os.write(sendBody.getBytes(encoding));
		} catch (IOException e) {
		}
	}

	public static String toAjaxArray(PageModel paged) {
		StringBuffer buffer = new StringBuffer("");

		buffer.append("{totalCount:");
		buffer.append(paged.getCount());
		buffer.append(",");
		buffer.append("results:");
		buffer.append(toJsonArray(paged.getData()));
		buffer.append("}");

		return buffer.toString();
	}

	@SuppressWarnings("unchecked")
	public static String tranformerJsonArray(final List result) {
		StringBuffer buffer = new StringBuffer("");
		buffer.append("{totalCount:");
		buffer.append(result.size());
		buffer.append(",");
		buffer.append("results:");
		buffer.append(toJsonArray(result));
		buffer.append("}");

		return buffer.toString();
	}

}