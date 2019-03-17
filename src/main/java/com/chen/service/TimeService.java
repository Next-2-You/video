package com.chen.service;


import java.util.List;

import com.chen.entities.Time;

public interface TimeService extends BaseService<Time> {
	
	public List<Time> getTimeList();
	
	
}
