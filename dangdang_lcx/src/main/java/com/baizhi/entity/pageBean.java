package com.baizhi.entity;

import java.io.Serializable;

public class pageBean implements Serializable {
	//表示是第几行的页码
	private Integer page;
	//表示每页显示多少条数据
	private Integer count;
	//表示诗句表里的总行数
	private Integer maxPage;
	public int getBegin(){
		return (page-1)*count+1;
		
	}
	//表示得到分页的结束行数
	public int getEnd(){
		return page*count+1;
		
	}
	public int getMaxpage(){
		int num = maxPage/count;
		if(num!=0){num++;}
		return num;
	}
	public pageBean() {
		super();
	}
	public pageBean(Integer page, Integer count, Integer maxPage) {
		super();
		this.page = page;
		this.count = count;
		this.maxPage = maxPage;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	@Override
	public String toString() {
		return "pageBean [page=" + page + ", count=" + count + ", maxPage="
				+ maxPage + "]";
	}
	
}
