package com.bai.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.DButil;

public class AdminServiceImpl implements AdminService {

	@Override
	public String queryAll(String username, String password,String code) {
		
		AdminDao dao = (AdminDao) DButil.getMapper(AdminDao.class);
		Admin admin1 = dao.selectAll(username);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code1 = (String)session.getAttribute("code");
		
		
		String message ;
		if (code1.equalsIgnoreCase(code)) {
			if (admin1 == null){
				message = "用户名不存在";
			}else if(password.equals(admin1.getPassword())){
				session.setAttribute("username", admin1.getUsername());
				message = "qwer";
			}else{
				message = "密码错误";
			}
		}else{
			message = "验证码错误";
			
		}
		
		return message;
			
			
		
		
	}

	

}
