package com.baizhi.test;





import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.bai.service.BookService;
import com.bai.service.BookServiceImpl;
import com.bai.service.OrderService;
import com.bai.service.OrderServiceImpl;
import com.baizhi.action.AddressAction;
import com.baizhi.dao.AddressDao;
import com.baizhi.dao.BookDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.dao.SecondBookDao;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.CateGroy;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.entity.pageBean;
import com.baizhi.util.DButil;
import com.baizhi.util.SnowFlake;




public class TestMaven {


	@Test
	public void test1(){
		
		OrderDao dao = (OrderDao)DButil.getMapper(OrderDao.class);
		Order order = new Order("2","3",3.0,null,"d","f","h","l",";"); 
		dao.insertOrder(order);
		DButil.commit();
	}
	
		

	
}

