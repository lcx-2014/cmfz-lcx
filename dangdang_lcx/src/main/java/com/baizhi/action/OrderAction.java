package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bai.service.OrderService;
import com.bai.service.OrderServiceImpl;
import com.baizhi.entity.Address;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;

public class OrderAction {
	private String newaddress;
	private Address address;
	private Order orders;
	private List<Order> list;
	private String id;
	private List<Item> lists;
	private Order order;
	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Item> getLists() {
		return lists;
	}

	public void setLists(List<Item> lists) {
		this.lists = lists;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	public String getNewaddress() {
		return newaddress;
	}

	public void setNewaddress(String newaddress) {
		this.newaddress = newaddress;
	}

	public String success(){
		System.out.println(address);
		if("xindizhi".equals(newaddress)){
			//则表示为新地址调用添加方法
			OrderService order = new OrderServiceImpl();
			order.addAddress(address);
			orders = order.addOrder(address);
			order.addItem(orders);
			order.addupBook();
			
		}else{
			//则表示为旧地址统一调用更新方法
			OrderService order = new OrderServiceImpl();
			order.upAddress(address);
			orders = order.addOrder(address);
			order.addItem(orders);
			order.addupBook();
		}
		return "success";
		
	}
	public String selectAll(){
		OrderService order = new OrderServiceImpl();
		list = order.queryAllOrder();
		return "selectAllOk";
	}
	public String selectItem(){
		OrderService order1 = new OrderServiceImpl();
		System.out.println(id);
		lists = order1.queryAllItem(id);
		order = order1.queryOrderById(id);
		System.out.println(lists);
		System.out.println(order);
		return "selectItemOk";

	}
}
