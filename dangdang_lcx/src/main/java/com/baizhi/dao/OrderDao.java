package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;

public interface OrderDao {
	//新地址添加方法
	public void insertAddress(Address address);
	//旧地址更新方法
	public void updateAddress(Address address);
	//订单入库
	public void insertOrder(Order order);
	//订单项入库
	public void insertItem(Item item);
	//查询所有订单用于回显后台所有的订单
	public List<Order> selectAllOrder();
	//根据订单id查询订单下所有的订单信息
	public List<Item> selectAllItem(String orderId);
	//根据订单id查询一个订单
	public Order selectOrderById(String orderId);
	
}
