package com.bai.service;

import java.util.List;

import com.baizhi.entity.CateGroy;

public interface CateGroyService {
	public List<CateGroy> queryAll();
	public List<CateGroy> queryCateGroy();
	public void addsecond(CateGroy cateGroy);
	public void addfirst(CateGroy cateGroy);
	public void downCate(String id);
}
