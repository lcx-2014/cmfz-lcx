package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
	private String id;
	private String bookId;
	private String name;
	private Double price;
	private Double dprice;
	private String cover;
	private Integer count;
	private Date createdate;
	private String orderId;
	public Item() {
		super();
	}
	public Item(String id, String bookId, String name, Double price,
			Double dprice, String cover, Integer count, Date createdate,
			String orderId) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.name = name;
		this.price = price;
		this.dprice = dprice;
		this.cover = cover;
		this.count = count;
		this.createdate = createdate;
		this.orderId = orderId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", bookId=" + bookId + ", name=" + name
				+ ", price=" + price + ", dprice=" + dprice + ", cover="
				+ cover + ", count=" + count + ", createdate=" + createdate
				+ ", orderId=" + orderId + "]";
	}
	
	
}
