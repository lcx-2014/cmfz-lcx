package com.bai.service;

import java.util.List;


import com.baizhi.entity.Address;

public interface AddressService {
	//根据用户id查询 所有地址用于回显下拉列表
	public  List<Address> queryByUserId(String id);
	//根据地址id查询地址用于地址回显
	public Address queryByAddId(String addId);
}
