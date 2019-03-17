package com.chen.action.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chen.entities.Manager;
import com.chen.service.ManagerService;
import com.chen.util.DataUtil;
import com.chen.util.ValidateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport{

	public Manager manager=new Manager();
	
	@Autowired
	public ManagerService managerService;
	
	
	private Map<String, Object> dataMap;
	
	

	public Map<String, Object> getDataMap() {
		return dataMap;
	}


	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}


	public Manager getManager() {
		return manager;
	}


	public void setManager(Manager manager) {
		this.manager = manager;
	}


	public String toLoginPage() {		
		return "adminLogin";
	}
	
	
	public String toMainPage() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Manager m = (Manager)session.get("manager");
		return "success";
	}

	
	
	/**
	 * 管理员登陆
	 * 
	 * ajax
	 * 
	 * @return
	 */
	public String doLogin() {
		String name = manager.getManagerName();
		String passwd = manager.getManagerPasswd();
		dataMap=new HashMap();
		dataMap.put("msg", false);
		if(!ValidateUtil.isValid(name)&&!ValidateUtil.isValid(passwd)) {	
			
			manager.setManagerPasswd(DataUtil.MD5(passwd));
			Manager m=managerService.findEntityByNameAndPwd(manager);
			if(m!=null) {	
				Map<String, Object> session = ActionContext.getContext().getSession();
				session.put("manager", m);
				dataMap.put("msg", true);
			}
		
		}
		return "showResult";		
	}
	
	
	public String doLoginOut() {	
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("manager");
		return "adminLogin";
	}
	

}
