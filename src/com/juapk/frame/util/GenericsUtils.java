package com.juapk.frame.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 泛型工具类
 * @author HUBIN
 * @version 1.0
 * @since 2012.01.17
 */
public class GenericsUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(GenericsUtils.class);

	private GenericsUtils() {
	}

	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			LOGGER.warn(clazz.getSimpleName()
					+ "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			LOGGER.warn("Index: " + index + ", Size of " + clazz.getSimpleName()
					+ "'s Parameterized Type: " + params.length);
			return Object.class;
		}
		
		if (!(params[index] instanceof Class)) {
			LOGGER.warn(clazz.getSimpleName()
							+ " not set the actual class on superclass generic parameter");
			return Object.class;
		}
		
		return (Class) params[index];
	}
	
	/**
	 * for batch delete
	 * 
	 * @param ids
	 * @return
	 */
	public static String createBlock(Object[] ids) {
		
		if (ids == null || ids.length == 0){
			return "('')";
		}
		
		String blockStr = "";
		
		for (int i = 0; i < ids.length - 1; i++) {
			blockStr += "'" + ids[i] + "',";
		}
		
		blockStr += "'" + ids[ids.length - 1] + "'";
		return blockStr;
	}

}