package com.baizhi.entity;

import java.util.List;
import java.io.Serializable;

public class CateGroy implements Serializable {
	private String id;
	private String name;
	private String parantId;
	private Integer levels;
	//添加自封装属性
	private CateGroy categroy;
	private List<CateGroy> categroys;
	//添加二级页面图书属性集合
	private List<Book> books;
	public CateGroy() {
		super();
	}
	public CateGroy(String id, String name, String parantId, Integer levels,
			CateGroy categroy, List<CateGroy> categroys, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.parantId = parantId;
		this.levels = levels;
		this.categroy = categroy;
		this.categroys = categroys;
		this.books = books;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParantId() {
		return parantId;
	}
	public void setParantId(String parantId) {
		this.parantId = parantId;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public CateGroy getCategroy() {
		return categroy;
	}
	public void setCategroy(CateGroy categroy) {
		this.categroy = categroy;
	}
	public List<CateGroy> getCategroys() {
		return categroys;
	}
	public void setCategroys(List<CateGroy> categroys) {
		this.categroys = categroys;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "CateGroy [id=" + id + ", name=" + name + ", parantId="
				+ parantId + ", levels=" + levels + ", categroy=" + categroy
				+ ", categroys=" + categroys + ", books=" + books + "]";
	}
	
	
}
