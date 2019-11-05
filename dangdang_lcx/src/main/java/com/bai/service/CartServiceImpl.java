package com.bai.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.util.DButil;

public class CartServiceImpl implements CartService {

	@Override
	//添加购物车
	public void winCart(String id) {
		 BookDao bookDao = (BookDao) DButil.getMapper(BookDao.class);
	        //通过id查询图书
	        Book book = bookDao.selectBook(id);
	        HttpSession session = ServletActionContext.getRequest().getSession(true);
	        //从session中获取购物车
	        Cart cart = (Cart)session.getAttribute("car");
	        //判断购物车是否为空
	        if(cart==null){
	           cart = new Cart();
	           //创建新的购物车项
	            CartItem cartItem = new CartItem();
	            cartItem.setBook(book);
	            cartItem.setCount(1);
	            Map<String, CartItem> map = cart.getCar();
	            map.put(id,cartItem);
	            //放入购物车
	            cart.setCar(map);
	            cart.setSavePrice(book.getPrice()-book.getDprice());
	            cart.setTotalPrice(book.getDprice());//总价
	        }else{
	            //判断购物项是否存在(containsKey判断map集合是否包含)
	            if(cart.getCar().containsKey(id)){
	                CartItem cartItem = cart.getCar().get(id);
	                cartItem.setCount(cartItem.getCount()+1);
	                Map<String, CartItem> map = cart.getCar();
	                map.put(id,cartItem);
	            }else {
	                CartItem cartItem = new CartItem();
	                cartItem.setBook(book);
	                cartItem.setCount(1);
	                Map<String, CartItem> map = cart.getCar();
	                map.put(id,cartItem);
	            }
	            cart.setSavePrice(cart.getSavePrice()+book.getPrice()-book.getDprice());
	            cart.setTotalPrice(cart.getTotalPrice()+book.getDprice());
	        }
	        //将购物车放回session
	        session.setAttribute("car",cart);
	        DButil.close();
	}

	@Override
	//变更购物车count的数量
	public void upCart(String id, Integer count) {
		//取出作用域里的session购物车
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart car = (Cart)session.getAttribute("car");
		//获取购物项
		Map<String, CartItem> car2 = car.getCar();
		//通过id键获取购物项
		CartItem item = car2.get(id);
		//获取旧的count
		Integer oldcount = item.getCount();
		//通过id查询此类商品的价格
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		Book book = dao.selectBook(id);
		//设置去除此类商品 的总金额和节省的金额
		car.setSavePrice(car.getSavePrice()-book.getPrice()*oldcount+book.getDprice()*oldcount);
		car.setTotalPrice(car.getTotalPrice()-book.getDprice()*oldcount);
		//将新的count设置总金额 和节省金额 
		item.setCount(count);
		car.setSavePrice(car.getSavePrice()+book.getPrice()*count-book.getDprice()*count);
		car.setTotalPrice(car.getTotalPrice()+book.getDprice()*count);
		session.setAttribute("car", car);
		DButil.close();
	
	}

	@Override
	public void deCart(String id) {
		//取出session作用域里的购物车
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart car = (Cart)session.getAttribute("car");
		//获得购物车
		Map<String, CartItem> car2 = car.getCar();
		//根据id获取购物车项
		CartItem item = car2.get(id);
		//获取此类商品的count数量
		Integer oldcount = item.getCount();
		//查询此类商品的价格用于获得总金额和节省金额
		BookDao dao = (BookDao)DButil.getMapper(BookDao.class);
		Book book = dao.selectBook(id);
		car.setSavePrice(car.getSavePrice()-book.getPrice()*oldcount+book.getDprice()*oldcount);
		car.setTotalPrice(car.getTotalPrice()-book.getDprice()*oldcount);
		session.setAttribute("car", car);
		car2.remove(id);
		DButil.close();
		
		
	}

}
