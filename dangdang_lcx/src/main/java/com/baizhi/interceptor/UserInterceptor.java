package com.baizhi.interceptor;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor{

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user == null) {
			//说明没有登陆
			return "userNo";
		}else{
			if (user.getCode() == null) {
				//说明没激活
				return "codeNo";
			}else{
				invocation.invoke();
			}
		}
		return null;
	}
}
