package com.bai.service;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;

public interface OrderService {
		//新地址添加
	public void addAddress(Address address);
	//旧地址更新方法
	public void upAddress(Address address);
	//订单入库
	public Order addOrder(Address address);
	//订单项入库
	public void addItem(Order order);
	public void addupBook();
	//查询所有订单由于后台的回显
	public List<Order> queryAllOrder();
	//根据订单id查询订单和此订单下所有的订单项
	public List<Item> queryAllItem(String orderId);
	public Order queryOrderById(String orderId);
}
