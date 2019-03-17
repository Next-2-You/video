package com.chen.entities;
/**
 * 集
 * 
 * @author Next 2 You
 * @2018年12月2日 下午11:12:59
 */
public class Episode {
	
	private Long id;
	private String episodeName;//集数名称
	private Integer episodeNumber;//集数
	
	private int statusId;//状态   //1.刪除2.使用中
	private Film film;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getEpisodeNumber() {
		return episodeNumber;
	}
	public void setEpisodeNumber(Integer episodeNumber) {
		this.episodeNumber = episodeNumber;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public String getEpisodeName() {
		return episodeName;
	}
	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

}
