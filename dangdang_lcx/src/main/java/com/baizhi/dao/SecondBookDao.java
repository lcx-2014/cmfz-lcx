package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;
import com.baizhi.entity.pageBean;


public interface SecondBookDao {
	public List<CateGroy> SecondBook(@Param("type")String type,@Param("pb")pageBean pb);
	public List<CateGroy> selectSecond(@Param("name")String name,@Param("pb")pageBean pb);
	public List<CateGroy> selectCateGroy(String parantid);
	//查询一级下共有多少本图书
	public  Integer selectCount(String types);
	//查询二级下共有多少涂图书
	public Integer queryCount(String names);
	//根据id查询图书的详细信息
	public Book selectDetalisBook(String id);
	
	
}
