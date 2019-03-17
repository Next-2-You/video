package com.chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.entities.Type;
import com.chen.service.TypeService;

@Service("typeService")
public class TypeServiceImpl extends BaseServiceImpl<Type> implements TypeService {

	@Resource(name = "typeDao")
	public void setDao(BaseDao<Type> dao) {
		this.dao = dao;
	}

	@Override
	public List<Type> getTypeList() {
		String hql = "from Type";
		return dao.findEntityByHQL(hql, null);
	}

}
