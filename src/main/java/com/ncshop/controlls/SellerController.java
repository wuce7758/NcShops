package com.ncshop.controlls;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncshop.domain.TGoods;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.domain.TUser;
import com.ncshop.service.SellerService;
import com.ncshop.service.UserService;


@Controller
public class SellerController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private SellerService sellerService;
	
	/**
	 * 查找某店铺订单
	 * @param OpenId 微信号标识
	 * @param orderState 订单状态
	 * @throws Exception
	 */
	@RequestMapping("/findOrders")
	public @ResponseBody List<TOrder> findOrders(int OpenId,int orderState) throws Exception{	
		//调用service查找 数据库
		List<TOrder> orderList=sellerService.findSellerOrder(OpenId,orderState);
		return orderList;
	}
	/**
	 * 添加店铺商品
	 * @throws Exception
	 */
	@RequestMapping("/addGoods")
	public void addGoods(@RequestBody TSellergoods sellergoods) throws Exception{	
		//调用service查找 数据库
		int userList=sellerService.addGoods(sellergoods);
	}
}
