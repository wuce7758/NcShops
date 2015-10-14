package com.ncshop.controlls;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TOrderdetail;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.domain.TUser;
import com.ncshop.service.UserService;
import com.ncshop.util.ConfigDao;
import com.ncshop.util.ConfigInfo;
import com.ncshop.util.TargetStrategy;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 查找所有店铺信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findAllShops")
	public void findAllShops(HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		try {
			List<TSeller> sellerList = userService.findAllSellers();
			String json = toJson(new TSeller(), sellerList, null);
			// 设置response的传输格式为json
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找店铺所有的商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findSellergoods")
	public void findSellergoods(TSeller seller, HttpServletResponse response)
			throws Exception {
		// 调用service查找 数据库
		List<TSellergoods> sellerGoodsList = userService
				.findSellergoods(seller);
		String json = toJson(new TSellergoods(), sellerGoodsList, null);
		// 设置response的传输格式为json
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * 查看商家单个商品
	 * 
	 * @param sellergoods
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findSellergood")
	public void findSellergoods(TSellergoods sellergoods,
			HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TSellergoods> sellerGoodsList = userService
				.findSellergood(sellergoods);
		String json = toJson(new TSellergoods(), sellerGoodsList, null);
		// 设置response的传输格式为json
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * 按商品类型获取商品数据
	 * 
	 * @param goodstype
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findgoods")
	public void findSellergoods(TGoodstype goodstype,
			HttpServletResponse response,HttpServletRequest request) throws Exception {
		try {
			
			String page = request.getParameter("page");
			int pageCount;
			List<TGoods> goodsList=null;
			//分页查找
			if(page!=null){
				pageCount=Integer.parseInt(page);
				// 调用service查找 数据库
				goodsList= userService.findgoods(goodstype,(pageCount-1)*10,10);
			}
			String json = toJson(new TGoods(), goodsList, null);
			// 设置response的传输格式为json
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查看商品
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping("/findAllGoods")
	public void findGoods(HttpServletResponse response,HttpServletRequest request) {
		try {
			String page = request.getParameter("page");
			System.out.println(page);
			int pageCount;
			List<TGoods> goodsList=null;
			//分页查找
			if(page!=null){
				pageCount=Integer.parseInt(page);
				goodsList= userService.findAllGoods((pageCount-1)*10,10);
			}
			String json = toJson(new TGoods(), goodsList, null);
			// 设置response的传输格式为json
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加入购物车
	 */
	@RequestMapping("/addOrders")
	public String addCart(HttpServletRequest request,
			HttpServletResponse response) {

		TGoods goods;
		TOrderdetail orderdetail;
		Set<TOrderdetail> orderdetails=new HashSet<TOrderdetail>();;
		Enumeration parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			
			String goodId = (String) parameterNames.nextElement();
			String num = request.getParameter(goodId);
			goods=userService.findgoodsById(goodId);
			orderdetail=new TOrderdetail();
			orderdetail.setTGoods(goods);
			orderdetail.setBuyMount(Integer.parseInt(num));
			orderdetail.setBuyCost(Integer.parseInt(num)*goods.getGoodsPrice());
		}
		request.getSession().setAttribute("odersdetails", orderdetails);
		//判断该用户是否是老用户
		
		//跳转到个人信息页面(送餐地址，电话)


		// 判断该用户是否是老用户

		// 跳转到个人信息页面(送餐地址，电话)
		return null;
	}

	/**
	 * 下订单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/order")
	public String order(HttpServletRequest request) {

		try {
			Set<TOrderdetail> odersdetails = (Set<TOrderdetail>) request
					.getSession().getAttribute("odersdetails");
			double orderTotalCost = 0.0;
			// 计算总金额
			for (Iterator iterator = odersdetails.iterator(); iterator
					.hasNext();) {
				TOrderdetail tOrderdetail = (TOrderdetail) iterator.next();
				orderTotalCost = tOrderdetail.getBuyCost()
						* tOrderdetail.getBuyMount();
			}

			TUser user = (TUser) request.getSession().getAttribute("user");

			TOrder order = new TOrder();
			order.setOrderState(0);
			order.setOrderTotalCost(orderTotalCost);
			order.setTOrderdetails(odersdetails);
			order.setOrderTime(new Date());

			if (userService.order(order)) {

				initMessageContext();

				// 获取配送员OpenID，组织消息并发送

				return null;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	/**
	 * 用户完善个人信息
	 * 
	 * @param user
	 * @param request
	 * @param response
	 */
	@RequestMapping("/bind")
	public void bindInfo(TUser user, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			TUser usermark = (TUser) request.getSession().getAttribute("user");
			user.setOpenId(usermark.getOpenId());
			if (userService.bind(user)) {
				// 信息填写成功，跳转
				request.getRequestDispatcher("").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@RequestMapping("/verifyOrder")
	public void verifyOrder(String orderId){
		
		try {
			
			TOrder order=userService.findOrderById(orderId);
			TUser user=userService.findUserById(order.getOrderId());
			//
			if(userService.upadateOrder(orderId)){
				
			}
			
			//订单 审核，将订单已受理信息发给用户
			//
			user.getOpenId();
			initMessageContext();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 将集合转换成json
	 * 
	 * @param t
	 * @param list
	 * @param fieldNames
	 * @param flag
	 * @return
	 */
	private <T> String toJson(T t, List<T> list, String[] fieldNames) {

		Gson gson = null;
		Map<String, List<T>> map = new HashMap<String, List<T>>();
		map.put(t.getClass().getName().replace("com.ncshop.domain.", ""), list);
		if (fieldNames != null) {
			TargetStrategy ts = null;
			ts = new TargetStrategy(t.getClass());
			ts.setReverse(true);
			ts.setFields(fieldNames);
			gson = new GsonBuilder().setExclusionStrategies(ts).create();
		} else {
			gson = new Gson();
		}
		String json = gson.toJson(map);
		System.out.println(json);
		return json;
	}
	
	private void initMessageContext(){
		WxMpInMemoryConfigStorage wxMpConfigStorage;
		WxMpService wxMpService;
		WxMpMessageRouter wxMpMessageRouter;
		ConfigDao configDao = new ConfigDao();
		ConfigInfo configInfo = configDao.GetConfig();
		wxMpConfigStorage = new WxMpInMemoryConfigStorage();
		wxMpConfigStorage.setAppId(configInfo.getWeChatAppID()); // 设置微信公众号的appid
		wxMpConfigStorage.setSecret(configInfo.getWeChatAppSecret()); // 设置微信公众号的app
		wxMpConfigStorage.setToken(configInfo.getWeChatToken()); // 设置微信公众号的token
		wxMpConfigStorage.setAesKey(configInfo.getWeChatAESKey()); // 设置微信公众号的EncodingAESKey
	}

}
