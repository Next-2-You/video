package com.chen.constant;

public enum StyleEnum {

	FILM(1, "电影"), TV_PLAY(2, "电视剧"), COMIC(3, "动漫");

	private Integer id;
	private String styleName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	private StyleEnum(Integer id, String styleName) {
		this.id = id;
		this.styleName = styleName;
	}

}
