package com.chen.service;


import java.util.List;

import com.chen.entities.Style;

public interface StyleService extends BaseService<Style> {
	
	public List<Style> getStyleList();
	
}
