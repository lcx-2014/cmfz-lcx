package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;

public interface BookDao {
	//查询有的book
	public List<Book> selectAll();
	//查询二级类别名称用于回显
	public List<CateGroy> selectScond();
	//添加book
	public void insertBook(Book book);
	//查询一个book用于为修改回显
	public Book selectBook(String id);
	//修改book
	public void updateBook(Book book);
	//根据 作者 出版社 书名进行模糊查询
	public List<Book> selectByname(String name);
	public List<Book> selectByauthor(String author);
	public List<Book> selectBypress(String press);
	//删除
	public void deleteBook(String id);
	//======================================以下是前台dao层
	//编辑推荐随机查询两本书用于展示
	public List<Book> randomBook();
	//排序进行热卖图书
	public List<Book> hotBook();
	//最新上架的图书
	public List<Book> newBook();
	//最新最热卖的图书
	public List<Book> newhotBook();
	//展示一级二级类别名称 表连接
	public List<CateGroy> categroyBook();
	//修改图书销量和存货
	public void updateBooks(Book book);
}
