package com.chen.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.dao.impl.EpisodeDaoImpl;
import com.chen.entities.Episode;
import com.chen.service.EpisodeService;

@Service("episodeService")
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService {

	
	@Resource(name="episodeDao")
	public void setDao(BaseDao<Episode> dao) {
		this.dao = dao;
	}

	@Override
	public List<Episode> getFilmEpisodeList(Long filmId) {
		String hql="from Episode where film_id=? order by episode_number";
		return this.dao.findEntityByHQL(hql, filmId);
	}
	
	@Override
	public List<Episode> getFilmEpisodeUserfulList(Long filmId) {
		String hql="from Episode where status_id=2 and film_id=? order by episode_number";
		return this.dao.findEntityByHQL(hql, filmId);
	}

	@Override
	public Episode getEntity(Long id) {
		return ((EpisodeDaoImpl)dao).getEntity(id);
	}
	
	@Override
	public void updateStatusId(Long id, int statusId) {
		String hql="update Episode set status_id=? where id=?";
		((EpisodeDaoImpl)this.dao).updateAttributes(hql, statusId,id);	
	}

	
	

}
