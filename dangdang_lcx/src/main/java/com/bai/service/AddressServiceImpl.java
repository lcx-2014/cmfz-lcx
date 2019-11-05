package com.bai.service;

import java.util.List;



import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.util.DButil;

public class AddressServiceImpl implements AddressService {

	@Override
	public List<Address> queryByUserId(String id) {
		AddressDao dao = (AddressDao)DButil.getMapper(AddressDao.class);
		List<Address> list = dao.selectByUserId(id);
		DButil.close();
		return list;
	}

	@Override
	public Address queryByAddId(String addId) {
		AddressDao dao = (AddressDao)DButil.getMapper(AddressDao.class);
		Address address = dao.selectByAddId(addId);
		DButil.close();
		return address;
	}

}
