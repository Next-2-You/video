package com.chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.entities.Time;
import com.chen.service.TimeService;

@Service("timeService")
public class TimeServiceImpl extends BaseServiceImpl<Time> implements TimeService {

	
	@Resource(name="timeDao")
	public void setDao(BaseDao<Time> dao) {
		this.dao = dao;
	}

	@Override
	public List<Time> getTimeList() {
		String hql="from Time order by id DESC";
		return dao.findEntityByHQL(hql, null);
	}
	
	
	

}
