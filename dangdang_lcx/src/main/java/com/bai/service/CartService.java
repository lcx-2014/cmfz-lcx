package com.bai.service;

import com.baizhi.entity.Cart;

public interface CartService {
	//添加购物车
	public void winCart(String id);
	//变更购物车的count数量
	public void upCart(String id,Integer count);
	//删除购物车
	public void deCart(String id);
}
