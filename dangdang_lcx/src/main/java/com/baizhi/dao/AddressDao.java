package com.baizhi.dao;

import java.util.List;


import com.baizhi.entity.Address;

public interface AddressDao {
	//根据用户id查询所在下的所有地址
	public List<Address> selectByUserId(String id);
	//根据地址id查询地址用于回显
	public Address selectByAddId(String addId);
}
