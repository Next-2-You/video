package com.chen.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class DataUtil {
	
	/**
	 * MD5加密
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String MD5(String str){
		
		try {
			byte[] bytes = str.getBytes();
			MessageDigest digest = MessageDigest.getInstance("MD5");		
			str = Hex.encodeHexString(digest.digest(bytes));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return str;
	}
	

}
