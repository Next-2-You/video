package com.chen.action.admin.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 后台管理拦截器
 * 
 * @author Next 2 You
 * @2019年3月16日 下午10:56:29
 */
public class AdminInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("进来拦截器了");
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		Object object = session.getAttribute("manager");
		if(object!=null) {
			String invoke = invocation.invoke();
			return invoke;

		}else {
			return "adminLogin";
		}
	}

}
