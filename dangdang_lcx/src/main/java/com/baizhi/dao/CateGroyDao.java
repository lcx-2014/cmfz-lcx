package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.CateGroy;

public interface CateGroyDao {
	public List<CateGroy> selectAll();
	public List<CateGroy> selectCateGroy();
	public void insertsecond(CateGroy cateGroy);
	public void insertfirst(CateGroy cateGroy);
	public void deleteCate(String id);
}
