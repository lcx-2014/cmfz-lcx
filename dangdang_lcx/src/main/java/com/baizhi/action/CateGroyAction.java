package com.baizhi.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bai.service.CateGroyService;
import com.bai.service.CateGroyServiceImpl;
import com.baizhi.entity.CateGroy;

public class CateGroyAction {
	private List<CateGroy> list;
	private List<CateGroy> cate;
	private CateGroy cateGroy;
	
	public CateGroy getCateGroy() {
		return cateGroy;
	}

	public void setCateGroy(CateGroy cateGroy) {
		this.cateGroy = cateGroy;
	}

	public List<CateGroy> getCate() {
		return cate;
	}

	public void setCate(List<CateGroy> cate) {
		this.cate = cate;
	}

	public List<CateGroy> getList() {
		return list;
	}

	public void setList(List<CateGroy> list) {
		this.list = list;
	}

	public String showCateGroy(){
		CateGroyService cate = new CateGroyServiceImpl();
		List<CateGroy> list = cate.queryAll();
		this.list = list;
		return "showOk";
		
	}
	public String showView(){
		CateGroyService cate1 = new CateGroyServiceImpl();
		List<CateGroy> cate = cate1.queryCateGroy();
		System.out.println(cate);
		this.cate=cate;
		return "showview";
		
	}
	public String addsecond(){
		CateGroyService cate = new CateGroyServiceImpl();
		cate.addsecond(cateGroy);
		return "addOk";
	}
	public String addfirst(){
		CateGroyService cat = new CateGroyServiceImpl();
		cat.addfirst(cateGroy);
		return "addfirstok";
	}
	public String deleteCate(){
	/*	CateGroyService cat = new CateGroyServiceImpl();
	 * 
		cat.downCate(cateGroy);*/
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String levels = request.getParameter("levels");
		int level = Integer.parseInt(levels);
		if(level==1){
			return "deleteNo";
		}else{

			CateGroyService cat = new CateGroyServiceImpl();
			cat.downCate(id);
			
			return "deleteOk";
		}
		
		
		
	}
	
}
