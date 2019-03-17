package com.chen.service;


import java.util.List;

import com.chen.entities.Status;

public interface StatusService extends BaseService<Status> {
	
	public List<Status> getStatusList();
	
	
}
