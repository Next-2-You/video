package com.chen.service;

import java.util.List;

import com.chen.entities.Episode;

public interface EpisodeService extends BaseService<Episode> {
	
	//得到某部视频的全部集数
	public List<Episode> getFilmEpisodeList(Long filmId);
	
	//得到某部视频上架的全部集数
	public List<Episode> getFilmEpisodeUserfulList(Long filmId);
	
	public Episode getEntity(Long id);
	
	public void updateStatusId(Long id, int statusId);
	
}
