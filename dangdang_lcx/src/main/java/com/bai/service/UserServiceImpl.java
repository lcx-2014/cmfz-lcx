package com.bai.service;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.DButil;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.VerifyCodeUtil;

public class UserServiceImpl implements UserService {

	@Override
	public String registerUser(User user,String code) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("nickname", user.getNickname());
		session.setAttribute("email", user.getEmail());
		String code1 = (String)session.getAttribute("code");
		if(!code1.equalsIgnoreCase(code)){
			return "验证码错误";
		}else{
			//生成随机盐
			String salt = MD5Utils.getSalt();
			String id = UUID.randomUUID().toString();
			user.setId(id);
			user.setSalt(salt);
			//使用随机盐给密码加密
			String newpassword = MD5Utils.getPassword(user.getPassword()+salt);
			user.setPassword(newpassword);
			user.setStatus("正常");
			UserDao dao = (UserDao)DButil.getMapper(UserDao.class);
			dao.insertUser(user);
			String codes = VerifyCodeUtil.generateVerifyCode(4);
			session.setAttribute("codes", codes);
			session.setAttribute("user", user);
			DButil.commit();
			return "registerOk";
		}
		
	}

	@Override
	public String upCode(String id, String code) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String codes = (String)session.getAttribute("codes");
		if(!codes.equalsIgnoreCase(code)){
			return "验证码错误";
		}else{
			UserDao dao = (UserDao)DButil.getMapper(UserDao.class);
			dao.updateCode(id, code);
			DButil.commit();
			return "upOk";
		}
			
	}

	@Override
	public String getUser(String email, String password) {
		UserDao dao = (UserDao)DButil.getMapper(UserDao.class);
		User user = dao.selectUser(email);
		HttpSession session = ServletActionContext.getRequest().getSession();

		String mea;
		if(user != null){
			if (!"正常".equals(user.getStatus())){
				mea = "账号已被冻结";
			}else if(!MD5Utils.getPassword(password+user.getSalt()).equals(user.getPassword())){
				mea="密码错误";
			}else{
				session.setAttribute("user", user);
				mea = "loginOk";
			}
			
		}else{
			mea= "邮箱不存在";
		}
		return mea;
		
		
	}

	@Override
	public List<User> queryAllUser() {
		UserDao dao = (UserDao)DButil.getMapper(UserDao.class);
		List<User> list = dao.selectAllUser();
		DButil.close();
		return list;
	}

	@Override
	public void upUser(User user) {
		try{
		UserDao dao = (UserDao)DButil.getMapper(UserDao.class);
		if("正常".equals(user.getStatus())){
			user.setStatus("冻结");
			dao.updateUser(user);
		}else{
			user.setStatus("正常");
			dao.updateUser(user);
		}
		DButil.commit();

		}catch(Exception e){
			e.printStackTrace();
			DButil.close();
		}
	}

}
