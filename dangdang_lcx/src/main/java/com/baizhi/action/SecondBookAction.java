package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bai.service.SecondService;
import com.bai.service.SecondServiceImpl;
import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;
import com.baizhi.entity.pageBean;

public class SecondBookAction {
	private String parantId;
	private List<CateGroy> list;
	private Integer levels;
	private String parpantIds;
	private List<CateGroy> lis;
	private String id;
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private List<CateGroy> listss;
	
	public List<CateGroy> getListss() {
		return listss;
	}

	public void setListss(List<CateGroy> listss) {
		this.listss = listss;
	}

	public List<CateGroy> getLis() {
		return lis;
	}

	public void setLis(List<CateGroy> lis) {
		this.lis = lis;
	}

	public String getParpantIds() {
		return parpantIds;
	}

	public void setParpantIds(String parpantIds) {
		this.parpantIds = parpantIds;
	}

	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public List<CateGroy> getList() {
		return list;
	}

	public void setList(List<CateGroy> list) {
		this.list = list;
	}

	public String getParantId() {
		return parantId;
	}

	public void setParantId(String parantId) {
		this.parantId = parantId;
	}

	public String secondAction(){
		if(levels==1){
			 HttpServletRequest request = ServletActionContext.getRequest();
			String pn = request.getParameter("pn");
			if(pn==null){pn="1";}
			pageBean pb = new pageBean(Integer.parseInt(pn),2,0);
			SecondService second = new SecondServiceImpl();
			 HttpSession session = request.getSession();
			session.setAttribute("levels", levels);
			session.setAttribute("parantid", parantId);
			listss = second.queryCateGroy(parantId);
			list = second.querySecond(parantId,pb);
			request.setAttribute("pb", pb);
			System.out.println(list);
			
			return "secondOk";
		}else{
			 HttpServletRequest request = ServletActionContext.getRequest();
			String pn = request.getParameter("pn");
			if(pn==null){pn="1";}
			pageBean pb = new pageBean(Integer.parseInt(pn),1,0);
			SecondService second = new SecondServiceImpl();
			 HttpSession session = request.getSession();
			session.setAttribute("levels", levels);
			session.setAttribute("parantid", parantId);
			session.setAttribute("parantids", parpantIds);
			lis = second.queryCateGroy(parpantIds);
			list = second.querySecondBook(parantId,pb);
			request.setAttribute("pb", pb);
			return "selectSecondBookOk";
		}
		
	}
	public String showDetalisBook(){
		
		SecondService second = new SecondServiceImpl();
		book = second.getDetalisBook(id);
		return "showDetalisOk";
	}
}
