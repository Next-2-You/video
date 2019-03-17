package com.chen.entities;

/**
 * 
 * 星星
 * 
 * @author Next 2 You
 * @2018年11月18日 上午11:12:25
 */
public class Starts {
	
	private Integer id;
	private User user;
	private Film film;
	private double starts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public double getStarts() {
		return starts;
	}
	public void setStarts(double starts) {
		this.starts = starts;
	}
	
	
	

}
