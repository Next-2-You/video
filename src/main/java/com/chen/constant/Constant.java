package com.chen.constant;

import org.apache.struts2.ServletActionContext;

public class Constant {
	
	public static final Integer PAGESIZE=16;//more页面和Search页面的记录数
	public static final Integer LEFTSIZE=8;//主页左边的记录数
	public static final Integer RIGHTSIZE=10;//主页右边的记录数
	
	public static final Integer INITSTART=0;//初始化时的开始记录数
	
	public static final String INDEXFILEPATH="D:\\\\videoproject";//索引文件路径
	
	public static final Integer isVIP=2;//是VIP
	
	public static final Integer  WATCHLINKTYPE=2;//默认是观看
	
	public static final Integer DOWNLOADLINKTYPE=1;//下载类型   迅雷

	
	public static final String PICTUREPATH="E:\\dev\\newworkspase\\video\\src\\main\\webapp\\statics\\images";
	public static final String PICTUREPATHcache=ServletActionContext.getRequest().getRealPath("/statics/images");
	
	public static final Integer UNAVAILABLE=1;//下架
	
	public static final Integer AVAILABLE=2;//上架
	
	

}
