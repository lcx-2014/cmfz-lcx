package com.bai.service;

import java.util.List;

import com.baizhi.dao.SecondBookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;
import com.baizhi.entity.pageBean;
import com.baizhi.util.DButil;

public class SecondServiceImpl implements SecondService {

	@Override
	public List<CateGroy> querySecond(String type,pageBean pb) {
		SecondBookDao dao = (SecondBookDao)DButil.getMapper(SecondBookDao.class);
		Integer maxpage = dao.selectCount(type);
		pb.setMaxPage(maxpage);
		List<CateGroy> list = dao.SecondBook(type,pb);
		
		DButil.close();
		return list;
	}

	@Override
	public List<CateGroy> querySecondBook(String name,pageBean pb) {
		SecondBookDao dao = (SecondBookDao)DButil.getMapper(SecondBookDao.class);
		Integer maxpage = dao.queryCount(name);
		pb.setMaxPage(maxpage);
		List<CateGroy> list = dao.selectSecond(name, pb);
		DButil.close();
		return list;
	}

	@Override
	public List<CateGroy> queryCateGroy(String parantId) {
		SecondBookDao dao = (SecondBookDao)DButil.getMapper(SecondBookDao.class);
			List<CateGroy> list = dao.selectCateGroy(parantId);
			DButil.close();
			return list;
	}

	@Override
	public Book getDetalisBook(String id) {
		SecondBookDao dao = (SecondBookDao)DButil.getMapper(SecondBookDao.class);
			Book book = dao.selectDetalisBook(id);
			DButil.close();
			return book;
	}

}
