package com.ncshop.controlls;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.domain.TUser;
import com.ncshop.service.SellerService;
import com.ncshop.service.UserService;


@Controller
@RequestMapping("/seller")
public class SellerController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private SellerService sellerService;
	
	/**
	 * 根据订单状态和微信标识查找某店铺订单
	 * @param OpenId 微信号标识
	 * @param orderState 订单状态
	 * @throws Exception
	 */
	@RequestMapping("/findSellerOrders")
	public void findSellerOrders(HttpServletResponse response,int OpenId,int orderState) throws Exception{	
		if(OpenId+""==""||orderState+""==""){
			return;
		}
		//调用service查找 数据库
		List<TOrder> orderList=sellerService.findSellerOrder(OpenId,orderState);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write("添加商品成功!");
	}
	/**
	 * 添加店铺商品
	 * @param sellerId 卖家唯一标识
	 * @param goods 新商品
	 * @throws Exception
	 */
	@RequestMapping("/addGoods")
	public void addGoods(HttpServletResponse response,int sellerId,int goodsTypeId,TGoods goods) throws Exception{	
		if(sellerId+""==""||goodsTypeId+""==""){
			return;
		}
		//调用service查找 数据库
		sellerService.addGoods(sellerId,goodsTypeId,goods);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("添加商品成功!");
	}
	/**
	 * 添加商品类型
	 * @param goodsType 商品类型对象
	 * @throws Exception
	 */
	@RequestMapping("/addGoodsType")
	public void addGoodsType(HttpServletResponse response,TGoodstype goodsType) throws Exception{	
		String goodsTypeName=goodsType.getGoodsTypeName();
		if(goodsTypeName==null||goodsTypeName==""){
			return;
		}
		//调用service查找 数据库
		sellerService.addGoodsType(goodsType);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write("添加商品类型成功!");
	}
	/**
	 * 拉黑用户
	 * @param goodsType 商品类型对象
	 * @throws Exception
	 */
	@RequestMapping("/limitUser")
	public void limitUser(HttpServletResponse response,int userId) throws Exception{	
		if(userId+""==null||userId+""==""){
			return;
		}
		//调用service查找 数据库
		sellerService.limitUser(userId);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write("限制成功!");
	}
}
