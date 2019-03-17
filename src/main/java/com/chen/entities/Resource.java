package com.chen.entities;
/**
 * 资源表
 * @author Next 2 You
 * @2018年12月2日 下午11:11:07
 */
public class Resource {
	
	private Long id;
	private Integer linkType;//链接类型   1：迅雷下载 2：在线观看地址
	private String link;//链接

	private Resolution resolution;//分辨率
	private Episode episode;//集数
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLinkType() {
		return linkType;
	}
	public void setLinkType(Integer linkType) {
		this.linkType = linkType;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Resolution getResolution() {
		return resolution;
	}
	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}
	public Episode getEpisode() {
		return episode;
	}
	public void setEpisode(Episode episode) {
		this.episode = episode;
	}

	
	
	

}
