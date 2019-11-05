package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private String id;
	private String orderNo;
	private Double total;
	private Date createdate;
	private String name;
	private String local;
	private String status;
	private String addressId;
	private String userId;
	public Order() {
		super();
	}
	public Order(String id, String orderNo, Double total, Date createdate,
			String name, String local, String status, String addressId,
			String userId) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.total = total;
		this.createdate = createdate;
		this.name = name;
		this.local = local;
		this.status = status;
		this.addressId = addressId;
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", total=" + total
				+ ", createdate=" + createdate + ", name=" + name + ", local="
				+ local + ", status=" + status + ", addressId=" + addressId
				+ ", userId=" + userId + "]";
	}
	
	
}
