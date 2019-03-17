package com.chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.entities.Region;
import com.chen.service.RegionService;

@Service("regionService")
public class RegionServiceImpl extends BaseServiceImpl<Region> implements RegionService {

	
	@Resource(name="regionDao")
	public void setDao(BaseDao<Region> dao) {
		this.dao = dao;
	}

	@Override
	public List<Region> getRegionList() {
		String hql = "from Region";
		return dao.findEntityByHQL(hql, null);
	}
	
	
	

}
