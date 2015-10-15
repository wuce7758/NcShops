package com.ncshop.controlls;

import java.util.Date;
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
import me.chanjar.weixin.mp.bean.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.WxMpTemplateMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncshop.domain.OrderItemArr;
import com.ncshop.domain.TAddress;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TOrderdetail;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.domain.TUser;
import com.ncshop.domain.TempOrder;
import com.ncshop.service.UserService;
import com.ncshop.util.ConfigDao;
import com.ncshop.util.ConfigInfo;
import com.ncshop.util.TargetStrategy;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	private WxMpInMemoryConfigStorage wxMpConfigStorage;
	private WxMpService wxMpService;
	private WxMpMessageRouter wxMpMessageRouter;

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
	public void findSellergoods(String sellerId, HttpServletResponse response)
			throws Exception {
		TSeller seller = new TSeller();
		seller.setSellerId(Integer.parseInt(sellerId));
		// 调用service查找 数据库
		List<TSellergoods> sellerGoodsList = userService
				.findSellergoods(seller);
		String json = toJson(new TSellergoods(), sellerGoodsList, null);
		// 设置response的传输格式为json
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * 查找店铺所有的商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findGoodsdetail")
	public void findGoodsdetail(HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TSellergoods> sellerGoodsList = userService.findGoodsdetail();
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
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		try {

			String page = request.getParameter("page");
			int pageCount;
			List<TGoods> goodsList = null;
			// 分页查找
			if (page != null) {
				pageCount = Integer.parseInt(page);
				// 调用service查找 数据库
				goodsList = userService.findgoods(goodstype,
						(pageCount - 1) * 10, 10);
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
	public void findGoods(HttpServletResponse response,
			HttpServletRequest request) {
		try {
			String page = request.getParameter("page");
			System.out.println(page);
			int pageCount;
			List<TGoods> goodsList = null;
			// 分页查找
			if (page != null) {
				pageCount = Integer.parseInt(page);
				goodsList = userService.findAllGoods((pageCount - 1) * 10, 10);
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
	public String addOrders(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			TGoods goods;
			TOrderdetail orderdetail;
			String goodId;
			String num;
			String json = request.getParameter("jsonString");
			System.out.println(json);
			Set<TOrderdetail> orderdetails = new HashSet<TOrderdetail>();
			Gson gson = new Gson();
			OrderItemArr fromJson = gson.fromJson(json, OrderItemArr.class);

			double allCost = 0;
			double cost = 0;
			for (TempOrder item : fromJson.getArray()) {
				goodId = item.getGoodsId();
				num = item.getBuyMount();
				goods = userService.findgoodsById(goodId);
				orderdetail = new TOrderdetail();
				orderdetail.setTGoods(goods);
				orderdetail.setBuyMount(Integer.parseInt(num));
				cost = Integer.parseInt(num) * goods.getGoodsPrice();
				orderdetail.setBuyCost(cost);
				allCost += cost;
				orderdetails.add(orderdetail);
			}
			request.getSession().setAttribute("odersdetails", orderdetails);

			request.setAttribute("allCost", allCost);
			TUser user = (TUser) request.getSession().getAttribute("user");

			TUser tempuser = userService.findUser(user.getOpenId());
			List<TAddress> address = null;
			if (user != null) {
				address = userService.findAddress(tempuser.getUserId());
			}
			request.setAttribute("address", address);
			request.getRequestDispatcher("/custom/MyOrder.jsp").forward(
					request, response);
			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 下订单
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/buy")
	public String buy(HttpServletRequest request) {

		try {
			Set<TOrderdetail> odersdetails = (Set<TOrderdetail>) request
					.getSession().getAttribute("odersdetails");
			double orderTotalCost = 0.0;
			TUser user = (TUser) request.getSession().getAttribute("user");
			initMessageContext();
			WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
			templateMessage.setToUser(user.getOpenId());
			templateMessage
					.setTemplateId("J80K1Uw6c_xDOy-D1btyuPNoi_nKgITtEV3tiwA_bzw");
			templateMessage.setUrl("www.baidu.com");
			templateMessage.setTopColor("#ff0000");
			// 计算总金额
			for (Iterator iterator = odersdetails.iterator(); iterator
					.hasNext();) {
				TOrderdetail tOrderdetail = (TOrderdetail) iterator.next();
				orderTotalCost = tOrderdetail.getBuyCost()
						* tOrderdetail.getBuyMount();
				templateMessage.getDatas().add(
						new WxMpTemplateData(tOrderdetail.getTGoods()
								.getGoodsName(), tOrderdetail.getBuyMount()
								+ " 份", "#173177"));
			}

			TOrder order = new TOrder();
			order.setOrderState(0);
			order.setOrderTotalCost(orderTotalCost);
			order.setTOrderdetails(odersdetails);
			order.setOrderTime(new Date());
			if (userService.order(order)) {
				// 给用户发送消息
				templateMessage.getDatas().add(
						new WxMpTemplateData("下单成功", orderTotalCost + "",
								"#ff000"));
				wxMpService.templateSend(templateMessage);
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
	@RequestMapping("/addAddress")
	public void bindInfo(TAddress address, int userId,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			TUser user = (TUser) request.getSession().getAttribute("user");
			if (user.getUserId() != null) {
				if (userService.updateAddress(user.getUserId(), address)) {
					List<TAddress> findAddress = userService.findAddress(2);
					request.setAttribute("address", findAddress);
					// 默认地址修改成功，跳转
					request.getRequestDispatcher("/custom/MyOrder.jsp")
							.forward(request, response);
				}
			}else{
				address.setIsDefault(true);
				userService.bind(user,address);
				request.getRequestDispatcher("/custom/MyOrder.jsp")
				.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 审核订单
	 * 
	 * @param orderId
	 */
	@RequestMapping("/verifyOrder")
	public void verifyOrder(String orderId) {

		try {

			TOrder order = userService.findOrderById(orderId);
			TUser user = userService.findUserById(order.getOrderId());
			//
			if (userService.upadateOrder(orderId)) {

			}

			// 订单 审核，将订单已受理信息发给用户
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

	private void initMessageContext() {
		ConfigDao configDao = new ConfigDao();
		ConfigInfo configInfo = configDao.GetConfig();
		wxMpConfigStorage = new WxMpInMemoryConfigStorage();
		wxMpConfigStorage.setAppId(configInfo.getWeChatAppID()); // 设置微信公众号的appid
		wxMpConfigStorage.setSecret(configInfo.getWeChatAppSecret()); // 设置微信公众号的app
		wxMpConfigStorage.setToken(configInfo.getWeChatToken()); // 设置微信公众号的token
		wxMpConfigStorage.setAesKey(configInfo.getWeChatAESKey()); // 设置微信公众号的EncodingAESKey
	}

}
