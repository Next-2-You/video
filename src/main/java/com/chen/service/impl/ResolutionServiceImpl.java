package com.chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.entities.Resolution;
import com.chen.service.ResolutionService;

@Service("resolutionService")
public class ResolutionServiceImpl extends BaseServiceImpl<Resolution> implements ResolutionService {

	
	@Resource(name="resolutionDao")
	public void setDao(BaseDao<Resolution> dao) {
		this.dao = dao;
	}

	@Override
	public List<Resolution> getRegionList() {
		String hql = "from Resolution";
		return dao.findEntityByHQL(hql, null);
	}


}
