package com.chen.service;

import java.util.List;

import com.chen.entities.Resource;

public interface ResourceService extends BaseService<Resource> {
	
	
	public List<Resource> getResourceList(Long episodeId,Integer linkType);
	
	public List<Resource> getFilmResourceList(Long episodeid);
	
	public Resource getEntity(Long id);
}
