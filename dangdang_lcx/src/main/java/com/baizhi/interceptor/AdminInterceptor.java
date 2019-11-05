package com.baizhi.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AdminInterceptor extends MethodFilterInterceptor{ 
	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object username = session.getAttribute("username");
		if(username==null){
			System.out.println(username);
			return "loginNo";
		}else{
			ai.invoke();
		}
		
		return null;
	}
}


