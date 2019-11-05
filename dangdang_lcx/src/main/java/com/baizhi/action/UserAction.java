package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bai.service.UserService;
import com.bai.service.UserServiceImpl;
import com.baizhi.entity.User;

public class UserAction {
	private User user;
	private String code;
	private List<User> list;
	
	
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String registerUser(){
		UserService us = new UserServiceImpl();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String message = us.registerUser(user, code);
		session.setAttribute("message", message);
		if("registerOk".equals(message)){
			return "register"; 
		}else{
			return "error";
		}
	}
	public String updateCode(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("user");
		
		user.setCode(code);
		UserService us = new UserServiceImpl();
		String messag = us.upCode(user.getId(), code);
		session.setAttribute("mess", messag);
		if("upOk".equals(messag)){
			return "updateCodeOk";
		}else{
			return "err";
		}

	}
	public String login(){
		UserService us = new UserServiceImpl();
		String msage = us.getUser(user.getEmail(), user.getPassword());
		if("loginOk".equals(msage)){
			return "loginOk";
		}else{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("msage", msage);
			return "loginerror";
		}
	}
	public String invalSession(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "invalSessionOk";
	}
	public String selectUser(){
		UserService us = new UserServiceImpl();
		list = us.queryAllUser();
		return "selectOk";
	}
	public String updateUser(){
		UserService us = new UserServiceImpl();
			us.upUser(user);
		
		return "updateOk";
	}
}
