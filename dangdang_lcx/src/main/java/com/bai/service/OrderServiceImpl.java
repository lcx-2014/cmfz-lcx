package com.bai.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.util.DButil;
import com.baizhi.util.SnowFlake;

public class OrderServiceImpl implements OrderService {

	
	@Override
	public void addAddress(Address address) {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute("user");
			String id = UUID.randomUUID().toString();
			address.setUserId(user.getId());
			address.setId(id);
			OrderDao dao = (OrderDao)DButil.getMapper(OrderDao.class);
			dao.insertAddress(address);
			DButil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			DButil.rollback();
		}
	}

	@Override
	public void upAddress(Address address) {
		try{
			OrderDao dao = (OrderDao)DButil.getMapper(OrderDao.class);
			dao.updateAddress(address);
			DButil.commit();
		}catch(Exception e){
			e.printStackTrace();
			DButil.close();
		}
		
	}

	@Override
	public Order addOrder(Address address) {
		try{
			Order order = new Order();
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = (User)session.getAttribute("user");
			//uuid生成主键
			String id = UUID.randomUUID().toString();
			order.setId(id);
			//雪花算法生成序列
			SnowFlake sn = new SnowFlake();
			order.setOrderNo(sn.getId());
			//设置订单总金额
			Cart car = (Cart)session.getAttribute("car");
			order.setTotal(car.getTotalPrice());
			//设置用户外键
			order.setUserId(user.getId());
			//设置支付状态
			order.setStatus("未付款");
			order.setName(address.getName());
			order.setLocal(address.getLocal());
			order.setCreatedate(new Date());
			//设置地址外键
			order.setAddressId(address.getId());
			OrderDao dao = (OrderDao)DButil.getMapper(OrderDao.class);
			dao.insertOrder(order);
			DButil.commit();
			return order;
		}catch(Exception e){
			e.printStackTrace();
			DButil.rollback();
			throw new RuntimeException("系统异常");
		}
		
	}
	public void addItem(Order order){
		try{
		HttpSession session = ServletActionContext.getRequest().getSession();
		OrderDao dao = (OrderDao)DButil.getMapper(OrderDao.class);
		Cart car = (Cart)session.getAttribute("car");
		  Map<String, CartItem> map = car.getCar();
          Set<String> set = map.keySet();
          for (String id : set) {
              CartItem cartItem = map.get(id);
              Item orderItem = new Item();
              orderItem.setId(UUID.randomUUID().toString());
             
              orderItem.setCount(cartItem.getCount());
          
              orderItem.setBookId(cartItem.getBook().getId());
              orderItem.setName(cartItem.getBook().getDname());
              orderItem.setPrice(cartItem.getBook().getPrice());
              orderItem.setDprice(cartItem.getBook().getDprice());
              orderItem.setCover(cartItem.getBook().getCover());
              orderItem.setOrderId(order.getId());
            
              orderItem.setCreatedate(new Date());
              //订单项入库
              dao.insertItem(orderItem);
           
          }
     
          DButil.commit();
      } catch (Exception e) {
          DButil.rollback();
      }
		
	}
	public void addupBook(){
		try{
			HttpSession session = ServletActionContext.getRequest().getSession();
			Cart car = (Cart)session.getAttribute("car");
			Map<String, CartItem> map = car.getCar();
			Set<String> set = map.keySet();
			
			for (String id : set) {
				BookDao bookDao = (BookDao)DButil.getMapper(BookDao.class);

				CartItem cartItem = map.get(id);
				System.out.println(cartItem.getBook().getId());
				
				Book book = bookDao.selectBook(cartItem.getBook().getId());
                book.setSale(book.getSale()+cartItem.getCount());
                book.setStock(book.getStock()-cartItem.getCount());
                System.out.println(book);
                bookDao.updateBook(book);
                DButil.commit();
			}
			 session.removeAttribute("car");
		}catch(Exception e){
			DButil.rollback();
		}
		
	}

	@Override
	public List<Order> queryAllOrder() {
		OrderDao dao = (OrderDao)DButil.getMapper(OrderDao.class);
		List<Order> list = dao.selectAllOrder();
		DButil.close();
		return list;
		
	}

	@Override
	public List<Item> queryAllItem(String orderId) {
		OrderDao dao = (OrderDao)DButil.getMapper(OrderDao.class);
		List<Item> list = dao.selectAllItem(orderId);
		DButil.close();
		return list;
	}

	@Override
	public Order queryOrderById(String orderId) {
		OrderDao dao = (OrderDao)DButil.getMapper(OrderDao.class);
		Order order = dao.selectOrderById(orderId);
		DButil.close();
		return order;
	}
}
