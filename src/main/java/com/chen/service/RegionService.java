package com.chen.service;


import java.util.List;

import com.chen.entities.Region;

public interface RegionService extends BaseService<Region> {
	
	public List<Region> getRegionList();
	
}
