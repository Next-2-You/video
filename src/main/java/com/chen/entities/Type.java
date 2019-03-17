package com.chen.entities;

import java.util.Set;

/**
 * 类型（科幻、剧情。。。）
 * 
 * @author Next 2 You
 * @2018年11月18日 上午11:02:26
 */
public class Type {

	
	private Integer id;
	private String typeName;
	
	private Set<Film> filmList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Set<Film> getFilmList() {
		return filmList;
	}
	public void setFilmList(Set<Film> filmList) {
		this.filmList = filmList;
	}
	
	
	
	
	
}
