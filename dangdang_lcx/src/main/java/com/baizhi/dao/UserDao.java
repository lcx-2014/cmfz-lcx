package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.User;

public interface UserDao {
	//用户注册
	public void insertUser(User user);
	//更新用户的激活码
	public void updateCode(@Param("id")String id,@Param("code")String code);
	//通过email查询一个联系人用于login判断
	public User selectUser(String email);
	//查询所有的用户用于为后台展示
	public List<User> selectAllUser();
	//修改用户的状态
	public void updateUser(User user);
}
