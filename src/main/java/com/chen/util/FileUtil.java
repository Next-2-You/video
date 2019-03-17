package com.chen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.UUID;

import com.chen.constant.Constant;

public class FileUtil {
	
	
	public static String Upload(File f,String path) {
		String fileName=null;
		if(f!=null) {
			try {
				fileName = System.currentTimeMillis()+new Random().nextInt(10000)+".jpg";
	            FileInputStream inputStream = new FileInputStream(f);
	            FileOutputStream outputStream = new FileOutputStream(path+"/"+ fileName);
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) {
	                outputStream.write(buf, 0, length);
	            }
	            inputStream.close();
	            outputStream.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		}
		return fileName;
	}
	
	
	public static String UploadCache(File f,String fileName,String path) {
		if(f!=null) {
			try {
	            FileInputStream inputStream = new FileInputStream(f);
	            FileOutputStream outputStream = new FileOutputStream(path+"/"+ fileName);
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) {
	                outputStream.write(buf, 0, length);
	            }
	            inputStream.close();
	            outputStream.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		}
		return fileName;
	}
	

}
