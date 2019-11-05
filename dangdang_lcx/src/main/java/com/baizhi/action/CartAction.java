package com.baizhi.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bai.service.CartService;
import com.bai.service.CartServiceImpl;
import com.baizhi.entity.Cart;

public class CartAction {
	private String id;
	private Integer count;
	
	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String addCart(){
		CartService cart = new CartServiceImpl();
		cart.winCart(id);
		return "addCartOk";
		
	}
	public String updateCart(){
		CartService cart = new CartServiceImpl();
		cart.upCart(id, count);
		return "updateCartOk";
	}
	public String deleteCart(){
		CartService cart = new CartServiceImpl();
		cart.deCart(id);
		return "deleteCartOk";
	}
}
