package com.baizhi.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
	private Map<String,CartItem> car = new HashMap<String,CartItem>();
	private Double savePrice;
	private Double totalPrice;
	public Cart() {
		super();
	}
	public Cart(Map<String, CartItem> car, Double savePrice, Double totalPrice) {
		super();
		this.car = car;
		this.savePrice = savePrice;
		this.totalPrice = totalPrice;
	}
	public Map<String, CartItem> getCar() {
		return car;
	}
	public void setCar(Map<String, CartItem> car) {
		this.car = car;
	}
	public Double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(Double savePrice) {
		this.savePrice = savePrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Cart [car=" + car + ", savePrice=" + savePrice
				+ ", totalPrice=" + totalPrice + "]";
	}
	
}
