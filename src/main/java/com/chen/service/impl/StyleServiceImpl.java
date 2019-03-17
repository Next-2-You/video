package com.chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.entities.Status;
import com.chen.entities.Style;
import com.chen.service.StyleService;

@Service("styleService")
public class StyleServiceImpl extends BaseServiceImpl<Style> implements StyleService {

	
	@Resource(name="styleDao")
	public void setDao(BaseDao<Style> dao) {
		this.dao = dao;
	}

	@Override
	public List<Style> getStyleList() {
		String hql ="from Style";
		return dao.findEntityByHQL(hql, null);
	}
	
	
	

}
