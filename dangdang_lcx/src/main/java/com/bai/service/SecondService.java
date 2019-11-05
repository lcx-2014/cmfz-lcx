package com.bai.service;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;
import com.baizhi.entity.pageBean;

public interface SecondService {
	public List<CateGroy> querySecond(String type,pageBean pb);
	public List<CateGroy> querySecondBook(String name,pageBean pb);
	public List<CateGroy> queryCateGroy(String parantId);
	//以上是二级页面展示的所有内容
	public Book getDetalisBook(String id);
	//以上是三级页面展示图书的详细信息 根据图书id查询
	 
}
