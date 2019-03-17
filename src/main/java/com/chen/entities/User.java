package com.chen.entities;

import java.util.Date;
import java.util.Set;

/**
 * 用户表
 * 
 * @author Next 2 You
 * @2018年11月18日 上午11:19:26
 */
public class User {
	
	private Long id;
	private String username;
	private String password;
	
	private String email;
	private String regCode;
	private Date createDate;
	
	private String headImage;
	private int isUse;
	
	//单向
	private Set<Film> filmList;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegCode() {
		return regCode;
	}
	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public int getIsUse() {
		return isUse;
	}
	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}
	public Set<Film> getFilmList() {
		return filmList;
	}
	public void setFilmList(Set<Film> filmList) {
		this.filmList = filmList;
	}
}
