package com.baizhi.action;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bai.service.AddressService;
import com.bai.service.AddressServiceImpl;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;

public class AddressAction {
	private List<Address> list;
	private String addId;
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}

	public List<Address> getList() {
		return list;
	}

	public void setList(List<Address> list) {
		this.list = list;
	}

	public String panduanSign(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
			AddressService ad = new AddressServiceImpl();
			list = ad.queryByUserId(user.getId());
			System.out.println(list);
			return "userOk";
		
			
	}
	public String getByAddId(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		AddressService ad = new AddressServiceImpl();
		address = ad.queryByAddId(addId);
		list = ad.queryByUserId(user.getId());
		
		return "ByAddIdOk";
	}
	

}
