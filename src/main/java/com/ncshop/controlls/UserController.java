package com.ncshop.controlls;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.service.UserService;


@Controller
@RequestMapping("user")
public class UserController{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 查找所有店铺信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAllShops")
	public @ResponseBody List<TSeller> findAllShops() throws Exception{	
		//调用service查找 数据库
		List<TSeller> userList=userService.findAllSellers();
		return userList;
	}
	/**
	 * 查找店铺所有的商品
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findSellergoods")
	public @ResponseBody Set<TSellergoods> findSellergoods(@RequestBody TSellergoods sellergoods) throws Exception{	
		//调用service查找 数据库
		Set<TSellergoods> userList=userService.findSellergoods(sellergoods.getTSeller().getSellerId());
		return userList;
	}
}
