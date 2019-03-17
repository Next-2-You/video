package com.chen.util;

import java.util.HashSet;
import java.util.Set;

import com.chen.entities.Type;

public class ChangeDataType {
	
	
//	public static <T> Set<T> String2Set(T t,String s,String str){
//		String[] split = str.split(",");
//		Set<T> set=new HashSet<>();
//		if(!ValidateUtil.isValid(split)) {
//			for(int i=0;i<split.length;i++) {
//				
//				
//				set.add
//			}
//	
//		}
//		
//		
//		
//		return null;
//	}
//	

	public static Set<Type> String2Set(String str){
		Set<Type> set=null;
		if(!ValidateUtil.isValid(str)) {
			String[] split = str.split(",");
			Type type=null;
			if(!ValidateUtil.isValid(split)) {
				set=new HashSet<>();
				for(int i=0;i<split.length;i++) {
					type=new Type();
					type.setId(Integer.valueOf(split[i]));
					set.add(type);
				}
		
			}
		}
		return set;
	}
	
	
	

}
