package com.baizhi.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.taglibs.standard.lang.jstl.test.PageContextImpl;

import com.bai.service.AdminService;
import com.bai.service.AdminServiceImpl;
import com.baizhi.entity.Admin;
import com.baizhi.util.VerifyCodeUtil;

public class AdminAction {
	private String id;
	private String username;
	private String password;
	private String code;
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String loginAction(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		AdminService ad = new AdminServiceImpl();
		String message = ad.queryAll(username, password, code);
		session.setAttribute("username", username);
		session.setAttribute("message",message);
		if ("qwer".equals(message)) {
			
			return "login";
		}else{
			System.out.println(message);
			
			return "error";
		}
		
	}
	
		
	
	public void getCodes() throws Exception{
		//获取相应对象
		HttpServletResponse response = ServletActionContext.getResponse();
		//设置响应类型
		response.setContentType("image/png");
		//获取验证码随机字符
		String code = VerifyCodeUtil.generateVerifyCode(4); 
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		
		//生成验证码图片
		BufferedImage image = VerifyCodeUtil.getImage(100, 40, code);
		ImageIO.write(image, "png", response.getOutputStream());
	}
	public String invalSessions(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "invalSessionOk";
	}
	
}
