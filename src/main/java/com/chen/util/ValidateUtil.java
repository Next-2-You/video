package com.chen.util;

import java.util.Collection;
import java.util.Map;

public class ValidateUtil {
	
	/**
	 * 判断字符串是否为空
	 * @param src
	 * @return
	 */
	public static boolean isValid(String src){
		return src==null || "".equals(src.trim());
	}
	
	/**
	 * 非空或者非零
	 * @param src
	 * @return
	 */
	public static boolean isNoZeroValid(String src){
		return src==null || "".equals(src.trim())||"0".equals(src.trim());
	}
	
	/**
	 * 判断集合是否为空
	 * @param col
	 * @return
	 */
	public static boolean isValid(Collection col){
		return col==null || col.isEmpty();
	}
	
	public static boolean isValid(Map map){
		return map==null || map.isEmpty();
	}
	
	/**
	 * 判断数组是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isValid(Object[] obj){
		return obj==null || obj.length==0;
	}
	
	

}
