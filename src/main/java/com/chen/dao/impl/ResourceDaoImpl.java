package com.chen.dao.impl;

import org.springframework.stereotype.Repository;

import com.chen.entities.Resource;

@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl<Resource> {
	
	public Resource getEntity(Long id) {
		return (Resource) sf.getCurrentSession().get(clazz, id);
	}

}
