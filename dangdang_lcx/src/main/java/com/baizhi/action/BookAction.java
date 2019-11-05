package com.baizhi.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bai.service.BookService;
import com.bai.service.BookServiceImpl;
import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;
import com.baizhi.util.DButil;

public class BookAction {
	private List<Book> list;
	private List<CateGroy> lis;
	private Book book;
	private File cover;
	private String coverFileName;
	private String key;
	private String content;
	private List<Book> lists;
	private List<Book> listss;
	private List<Book> listsss;
	private List<CateGroy> listssss;
 	
	public List<CateGroy> getListssss() {
		return listssss;
	}

	public void setListssss(List<CateGroy> listssss) {
		this.listssss = listssss;
	}

	public List<Book> getListsss() {
		return listsss;
	}

	public void setListsss(List<Book> listsss) {
		this.listsss = listsss;
	}

	public List<Book> getListss() {
		return listss;
	}

	public void setListss(List<Book> listss) {
		this.listss = listss;
	}

	public List<Book> getLists() {
		return lists;
	}

	public void setLists(List<Book> lists) {
		this.lists = lists;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<CateGroy> getLis() {
		return lis;
	}

	public void setLis(List<CateGroy> lis) {
		this.lis = lis;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	public String showBook(){
		BookService bok = new BookServiceImpl();
		List<Book> list = bok.queryAll();
		
		this.list = list;
		return "showBookOk";
	}
	public String showSecond(){
		
		BookService bok = new BookServiceImpl();
		List<CateGroy> lis = bok.querySecond();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("list", lis);
		this.lis=lis;
		return "showSecondOk";
	}
	public String addBook(){
		 //根据相对路径获得绝对路径
		 //根据相对路径获得绝对路径
        String realPath = ServletActionContext.getServletContext().getRealPath("/back/img");
        //放置图片被覆盖
        //String newName = new Date().getTime()+"-"+coverFileName;
        try {
            //文件上传
            FileUtils.copyFile(cover, new File(realPath, coverFileName));
            //图书添加
            book.setCover(coverFileName);
            BookService bsi = new BookServiceImpl();
            bsi.addBook(book);
        }catch(Exception e){
            e.printStackTrace();
        }
		return "addBookOk";
	}
	public String selectBook(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		BookService bk= new BookServiceImpl();
		Book bo = bk.queryBook(id);
		request.setAttribute("bo", bo);
		return "selectBookOk";
		
	}
	public String updateBook(){
		 //根据相对路径获得绝对路径
		 //根据相对路径获得绝对路径
       String realPath = ServletActionContext.getServletContext().getRealPath("/back/img");
       //放置图片被覆盖
       String newName = new Date().getTime()+"-"+coverFileName;
       try {
           //文件上传
       	
           FileUtils.copyFile(cover, new File(realPath, newName));
           //图书添加
           book.setCover(newName);
           System.out.println(book.getCover());
       }catch(Exception e){
           e.printStackTrace();
       }
		BookService BK = new BookServiceImpl();
		BK.update(book);
		return "updateOk";
	}
	public String blurqueryBook(){
		BookService bk = new BookServiceImpl();
		list = bk.blurBook(key, content);
		return "blurOk";
	}
	public String delete(){
		BookService bk = new BookServiceImpl();
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		bk.downBook(id);
		return "deleteOk";
	}
	//=============以下是前台的book的回显
	public String random(){
		BookService bk = new BookServiceImpl();
		list = bk.randomquery();
		lists= bk.hotquery();
		listss = bk.newquery();
		listsss = bk.newhotquery();
		listssss = bk.categroyquery();
		return "randomOk";
	}
}
