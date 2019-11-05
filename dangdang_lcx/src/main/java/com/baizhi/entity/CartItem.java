package com.baizhi.entity;

import java.io.Serializable;

public class CartItem implements Serializable{
	private Book book;
	private Integer count;
	private Double sub;
	public CartItem() {
		super();
	}
	public CartItem(Book book, Integer count, Double sub) {
		super();
		this.book = book;
		this.count = count;
		this.sub = sub;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSub() {
		return sub;
	}
	public void setSub(Double sub) {
		this.sub = sub;
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", sub=" + sub
				+ "]";
	}
	
	

}
