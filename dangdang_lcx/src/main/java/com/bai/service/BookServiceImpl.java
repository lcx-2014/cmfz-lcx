package com.bai.service;

import java.util.List;
import java.util.UUID;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;
import com.baizhi.util.DButil;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> queryAll() {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		List<Book> list = dao.selectAll();
		DButil.close();
		return list;
	}

	@Override
	public List<CateGroy> querySecond() {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		List<CateGroy> list = dao.selectScond();
		DButil.close();
		return list;
	}

	@Override
	public void addBook(Book book) {
		try{
			BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
			String id = UUID.randomUUID().toString();
			book.setId(id);
			dao.insertBook(book);
			DButil.commit();
		}catch(Exception e){
			e.printStackTrace();
			DButil.rollback();
		}
		
	}

	@Override
	public Book queryBook(String id) {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		Book book = dao.selectBook(id);
		DButil.close();
		return book;
	}

	@Override
	public void update(Book book) {
		try{
			BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
			dao.updateBook(book);
			DButil.commit();
		}catch(Exception e){
			e.printStackTrace();
			DButil.rollback();
		}
		
	}

	@Override
	public List<Book> blurBook(String par, String text) {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		List<Book> list;
		if("name".equals(par)){
			list = dao.selectByname("%"+text+"%");
			DButil.close();
		}else if("press".equals(par)){
			list = dao.selectBypress("%"+text+"%");
			DButil.close();
		}else{
			list = dao.selectByauthor("%"+text+"%");
			DButil.close();
		}
		return list;
	}

	@Override
	public void downBook(String id) {
		try{
			BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
			dao.deleteBook(id);
			DButil.commit();
		}catch(Exception e){
			e.printStackTrace();
			DButil.rollback();
		}
		
	}

	@Override
	public List<Book> randomquery() {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		List<Book> list = dao.randomBook();
		DButil.close();
		return list;
		
	}

	@Override
	public List<Book> hotquery() {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		List<Book> list = dao.hotBook();
		DButil.close();
		return list;
	}

	@Override
	public List<Book> newquery() {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		List<Book> list = dao.newBook();
		DButil.close();
		return list;
	}

	@Override
	public List<Book> newhotquery() {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		List<Book> list = dao.newhotBook();
		DButil.close();
		return list;
	}

	@Override
	public List<CateGroy> categroyquery() {
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		List<CateGroy> list = dao.categroyBook();
		DButil.close();
		return list;
	}

}
