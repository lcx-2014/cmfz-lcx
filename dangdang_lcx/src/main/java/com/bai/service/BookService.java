package com.bai.service;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;

public interface BookService {
	public List<Book> queryAll();
	//查询二级类别名称用于回显
	public List<CateGroy> querySecond();
	public void addBook(Book book);
	public Book queryBook(String id);
	public void update(Book book);
	//模糊查询
	public List<Book> blurBook(String par,String text);
	public void downBook(String id);
	//=================以下是前台关于book的service
	public List<Book> randomquery();
	//热卖图书
	public List<Book> hotquery();
	//根据出版时间最新上架的图书
	public List<Book> newquery();
	//最新最热卖的图书
	public List<Book> newhotquery();
	//类别展示图书
	public List<CateGroy> categroyquery();
}
