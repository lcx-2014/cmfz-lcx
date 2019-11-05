package com.bai.service;

import java.util.List;

import com.baizhi.entity.User;

public interface UserService {
	//用户注册
	public String registerUser(User user,String code);
	//更新用户的激活码
	public String upCode(String id,String code);
	//通过email查询判断是是否满足登录条件使用MD5加密
	public String getUser(String email,String password);
	//查询所有的用户
	public List<User> queryAllUser();
	//修改用户的状态
	public void upUser(User user);
}
