package com.chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.chen.dao.BaseDao;
import com.chen.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	public BaseDao<T> dao;

	@Resource
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	@Override
	public void saveEntity(T t) {
		this.dao.saveEntity(t);
	}


	@Override
	public void saveOrUpdateEntity(T t) {
		this.dao.saveOrUpdateEntity(t);
	}

	@Override
	public void updateEntity(T t) {
		this.dao.updateEntity(t);
	}

	@Override
	public void deleteEntity(T t) {
		this.dao.deleteEntity(t);
	}

	@Override
	public void batchEntityByHQL(String hql, Object... objects) {
		this.dao.batchEntityByHQL(hql, objects);
	}

	@Override
	public T loadEntity(Integer id) {
		return this.dao.loadEntity(id);
	}

	@Override
	public T getEntity(Integer id) {
		return this.dao.getEntity(id);
	}

	@Override
	public List<T> findEntityByHQL(String hql, Object... objects) {
		return this.dao.findEntityByHQL(hql, objects);
	}
	
	

}
