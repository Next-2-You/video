package com.chen.service;


import java.util.List;

import com.chen.entities.Type;

public interface TypeService extends BaseService<Type> {
	
	public List<Type> getTypeList();
	
}
