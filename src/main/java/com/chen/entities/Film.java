package com.chen.entities;

import java.util.Date;
import java.util.Set;

public class Film {

	private Long id;
	private String filmName;
	private String filmImage;
	
	private String actor;//演员
	private String director;//导演
	private String introduction;//简介
	private double statrs;//星星
	
	private Date releaseTime;//上映时间
	private int isVIP;
	private String beanlink;//豆瓣链接
	private int statusId;//状态

	private Region region;//地区
	private Time time;//年代
	private Style style;//类别
	
	//双向
	private Set<Type> typeList;//类型
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public String getFilmImage() {
		return filmImage;
	}
	public void setFilmImage(String filmImage) {
		this.filmImage = filmImage;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public double getStatrs() {
		return statrs;
	}
	public void setStatrs(double statrs) {
		this.statrs = statrs;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public int getIsVIP() {
		return isVIP;
	}
	public void setIsVIP(int isVIP) {
		this.isVIP = isVIP;
	}
	public String getBeanlink() {
		return beanlink;
	}
	public void setBeanlink(String beanlink) {
		this.beanlink = beanlink;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public Set<Type> getTypeList() {
		return typeList;
	}
	public void setTypeList(Set<Type> typeList) {
		this.typeList = typeList;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", filmName=" + filmName + ", filmImage=" + filmImage + ", actor=" + actor
				+ ", director=" + director + ", introduction=" + introduction + ", statrs=" + statrs + ", releaseTime="
				+ releaseTime + ", isVIP=" + isVIP + ", beanlink=" + beanlink + ", statusId=" + statusId + ", region="
				+ region + ", time=" + time + ", style=" + style + ", typeList=" + typeList + "]";
	}
	
	
	
	
}
