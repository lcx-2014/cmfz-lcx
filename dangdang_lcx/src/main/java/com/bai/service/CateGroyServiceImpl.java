package com.bai.service;

import java.util.List;
import java.util.UUID;

import com.baizhi.dao.CateGroyDao;
import com.baizhi.entity.CateGroy;
import com.baizhi.util.DButil;

public class CateGroyServiceImpl implements CateGroyService {

	@Override
	public List<CateGroy> queryAll() {
		CateGroyDao dao = (CateGroyDao)DButil.getMapper(CateGroyDao.class);
		List<CateGroy> list = dao.selectAll();
		DButil.close();
		return list;
	}

	@Override
	public List<CateGroy> queryCateGroy() {
		try{
			CateGroyDao dao = (CateGroyDao)DButil.getMapper(CateGroyDao.class);
			List<CateGroy> list = dao.selectCateGroy();
			DButil.close();
			return list;
			
		}catch(Exception e){
			e.printStackTrace();
			DButil.rollback();
			throw new RuntimeException("系统异常");
		}
	}

	@Override
	public void addsecond(CateGroy cateGroy) {
		try{
		CateGroyDao dao = (CateGroyDao)DButil.getMapper(CateGroyDao.class);
		String id = UUID.randomUUID().toString();
		cateGroy.setId(id);
		cateGroy.setLevels(2);
		dao.insertsecond(cateGroy);
		DButil.commit();
		}catch(Exception e){
			e.printStackTrace();
			DButil.rollback();
			
		}
		
	}

	@Override
	public void addfirst(CateGroy cateGroy) {
		try{
		CateGroyDao dao = (CateGroyDao)DButil.getMapper(CateGroyDao.class);
		String id = UUID.randomUUID().toString();
		cateGroy.setId(id);
		cateGroy.setLevels(1);
		cateGroy.setParantId(null);
		dao.insertfirst(cateGroy);
		DButil.commit();
		}catch(Exception e){
			e.printStackTrace();
			DButil.rollback();
		}
		
	}

	@Override
	public void downCate(String id) {
		try{
		CateGroyDao dao = (CateGroyDao)DButil.getMapper(CateGroyDao.class);
		dao.deleteCate(id);
		DButil.commit();
		}catch(Exception e){
			e.printStackTrace();
			DButil.rollback();
		}
	}


	
		
	

}
