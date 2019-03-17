package com.chen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.dao.impl.ResourceDaoImpl;
import com.chen.entities.Resource;
import com.chen.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

	@Autowired
	@Qualifier("resourceDao")
	public void setDao(BaseDao<Resource> dao) {
		this.dao = dao;
	}

	@Override
	public List<Resource> getResourceList(Long episodeId, Integer linkType) {
		String hql="from Resource where episode_id=? and link_type=? order by resolution_id";
		return this.dao.findEntityByHQL(hql, episodeId,linkType);
	}
	
	@Override
	public List<Resource> getFilmResourceList(Long episodeId) {
		String hql="from Resource where episode_id=?";
		return this.dao.findEntityByHQL(hql, episodeId);
	}
	
	@Override
	public Resource getEntity(Long id) {
		return ((ResourceDaoImpl)this.dao).getEntity(id);
	}

}
