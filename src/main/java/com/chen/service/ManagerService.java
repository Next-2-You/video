package com.chen.service;

import com.chen.entities.Manager;

public interface ManagerService extends BaseService<Manager> {

	Manager findEntityByNameAndPwd(Manager manager);

}
