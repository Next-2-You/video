package com.chen.entities;

import java.util.Date;
/**
 * vip表
 * 
 * @author Next 2 You
 * @2018年11月18日 上午11:12:25
 */
public class Vipcode {
	
	private Long id;
	private String code;
	private Date createTime;
	private Date expireTime;
	private User user;//较安全
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	
}
