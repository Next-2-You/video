package com.chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.entities.Status;
import com.chen.service.StatusService;

@Service("statusService")
public class StatusServiceImpl extends BaseServiceImpl<Status> implements StatusService {

	
	@Resource(name="statusDao")
	public void setDao(BaseDao<Status> dao) {
		this.dao = dao;
	}

	@Override
	public List<Status> getStatusList() {
		String hql="from Status";
		return dao.findEntityByHQL(hql, null);
	}
	
	
	

}
