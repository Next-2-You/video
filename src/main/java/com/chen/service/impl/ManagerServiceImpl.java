package com.chen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chen.dao.BaseDao;
import com.chen.entities.Manager;
import com.chen.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl extends BaseServiceImpl<Manager> implements ManagerService {

	
	@Resource(name="managerDao")
	public void setDao(BaseDao<Manager> dao) {
		this.dao = dao;
	}

	@Override
	public Manager findEntityByNameAndPwd(Manager manager) {
		
		String hql="from Manager where manager_name=? and manager_passwd=?";
		
		List<Manager> list = dao.findEntityByHQL(hql, manager.getManagerName(),manager.getManagerPasswd());//不会等于null，没有也会生成list对象
		return list.size()==0?null:list.get(0);
	}

}
