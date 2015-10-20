package com.ncshop.controlls;

import java.util.ArrayList;
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
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.WxMpTemplateMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

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
import com.ncshop.util.LogBuilder;
import com.ncshop.util.TargetStrategy;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	private WxMpInMemoryConfigStorage wxMpConfigStorage;
	private WxMpService wxMpService;
	private WxMpMessageRouter wxMpMessageRouter;
	private ConfigDao configDao;
	private ConfigInfo configInfo;

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
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
		}
	}

	/**
	 * 查找店铺所有的商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findSellergoods")
	public void findSellergoods(String sellerId, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			String page = request.getParameter("page");
			int pageCount;
			List<TSellergoods> sellerGoodsList = null;
			if (page != null) {
				pageCount = Integer.parseInt(page);
				// 调用service查找 数据库
				sellerGoodsList = userService.findSellergoods(
						Integer.parseInt(sellerId), (pageCount - 1) * 10, 10);
			}
			// 调用service查找 数据库
			List<TGoods> goods = new ArrayList<TGoods>();
			for (TSellergoods tSellergoods : sellerGoodsList) {
				goods.add(tSellergoods.getTGoods());
			}
			String json = toJson(new TGoods(), goods, null);
			// 设置response的传输格式为json
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
		}

	}

	/**
	 * 查找店铺所有的商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findGoodsdetail")
	public void findGoodsdetail(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			// 调用service查找 数据库
			List<TSellergoods> sellerGoodsList = userService.findGoodsdetail();
			String json = toJson(new TSellergoods(), sellerGoodsList, null);
			request.setAttribute("goodDetail", sellerGoodsList);
			request.getRequestDispatcher("/admin/page/goods.jsp").forward(
					request, response);
			return;
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
		}

	}

	/**
	 * 按商品类型获取商品数据
	 * 
	 * @param goodstype
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/findgoodsByType")
	public void findgoodsByType(String goodsTypeId,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		try {

			String page = request.getParameter("page");
			System.out.println(page);
			int pageCount;
			List<TSellergoods> goodsList = null;
			TGoodstype goodstype = new TGoodstype();
			goodstype.setGoodsTypeId(Integer.parseInt(goodsTypeId));
			// 分页查找
			if (page != null) {
				pageCount = Integer.parseInt(page);
				// 调用service查找 数据库
				goodsList = userService.findgoods(goodstype, 101,
						(pageCount - 1) * 10, 10);
			}
			List<TGoods> goods = new ArrayList<TGoods>();
			for (TSellergoods tSellergoods : goodsList) {
				if (tSellergoods.getTGoods().getTGoodstype().getGoodsTypeId() == (Integer
						.parseInt(goodsTypeId))) {
					goods.add(tSellergoods.getTGoods());
				}
			}
			String json = toJson(new TGoods(), goods, null);
			// 设置response的传输格式为json
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
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
			List<TSellergoods> goodsList = null;
			// 分页查找
			if (page != null) {
				pageCount = Integer.parseInt(page);
				goodsList = userService.findSellergoods(101,
						(pageCount - 1) * 10, 10);
			}

			List<TGoods> goods = new ArrayList<TGoods>();
			if (goodsList != null) {
				for (TSellergoods tSellergoods : goodsList) {
					goods.add(tSellergoods.getTGoods());
				}
			}
			String json = toJson(new TGoods(), goods, null);
			// 设置response的传输格式为json
			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
		}
	}

	/**
	 * 加入购物车
	 */
	@RequestMapping("/addOrders")
	public String addOrders(HttpServletRequest request,
			HttpServletResponse response) {
		TGoods goods;
		TOrderdetail orderdetail;
		String goodId;
		String num;
		try {

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

			request.getSession().setAttribute("allCost", allCost);
			TUser user = (TUser) request.getSession().getAttribute("user");
			List<TAddress> address = null;
			if (user != null) {
				if (user.getUserId() != null) {
					address = userService.findAddress(user.getUserId());
					TUser tempUser = userService.findUser(user.getOpenId());

				}
			}
			request.setAttribute("address", address);
			request.getRequestDispatcher("/custom/MyOrder.jsp").forward(
					request, response);
			return null;

		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
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
	public void buy(HttpServletRequest request, HttpServletResponse response) {

		String msg = "";
		TOrderdetail tOrderdetail = null;
		try {
			Set<TOrderdetail> odersdetails = (Set<TOrderdetail>) request
					.getSession().getAttribute("odersdetails");
			double orderTotalCost = 0.0;
			TUser user = (TUser) request.getSession().getAttribute("user");

			// 计算总金额

			for (Iterator iterator = odersdetails.iterator(); iterator
					.hasNext();) {
				tOrderdetail = (TOrderdetail) iterator.next();
				orderTotalCost += tOrderdetail.getBuyCost();
				msg += "                 "
						+ tOrderdetail.getTGoods().getGoodsName() + "  x"
						+ tOrderdetail.getBuyMount() + "\n";
			}

			TOrder order = new TOrder();
			order.setOrderNo(new Date().getTime() + "");
			order.setOrderState(0);
			order.setOrderTotalCost(orderTotalCost);
			if (user == null) {
				order.setUserId(1);
			} else {
				order.setUserId(user.getUserId());
			}
			TSellergoods sellergoods = userService
					.findSellergoodsByGoodsID(tOrderdetail.getTGoods()
							.getGoodsId());
			// TSeller seller = new TSeller();
			// seller.setSellerId();
			order.setSellerId(sellergoods.getSeller().getSellerId());
			if (userService.order(order, odersdetails)) {
				// 给用户发送消息
				TAddress address = userService.findAddress(user.getUserId())
						.get(0);
				initMessageContext();
				WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
				// templateMessage.setToUser(user.getOpenId());
				templateMessage.setToUser(user.getOpenId());
				// 发送给下单人的消息
				templateMessage
						.setTemplateId("EXTbx95V3C88AlDMwfsCZQvrgAtMyox5x4aeqLir2mM");
				templateMessage
						.setUrl("ncshop.zcdreams.com/user/findOrderByOrderNo?orderNo="
								+ order.getOrderNo());
				templateMessage.setTopColor("#ff0000");
				templateMessage.getDatas().add(
						new WxMpTemplateData("first", "你有一个新订单",
								"#173177"));
				templateMessage.getDatas().add(
						new WxMpTemplateData("keyword1",order.getOrderNo() ,
								"#173177"));
				templateMessage.getDatas()
						.add(new WxMpTemplateData("keyword2", order.getOrderTime().toLocaleString()));
				templateMessage.getDatas().add(
						new WxMpTemplateData("keyword3", address.getReceiverName(), "#173177"));
				templateMessage.getDatas().add(
						new WxMpTemplateData("keyword4", address.getAdsPhone(), "#173177"));
				templateMessage.getDatas().add(
						new WxMpTemplateData("keyword5", address.getAdsContent(), "#173177"));
				templateMessage.getDatas().add(
						new WxMpTemplateData("remark", "点击查看订单详情，如有疑问请联系商家，"+"18770015729", "#173177"));
				wxMpService.templateSend(templateMessage);

				// 通知商家有新的订单

				WxMpTemplateMessage toBoss = new WxMpTemplateMessage();
				toBoss.setToUser("o6giMtx2laitNbxP_U1AgdMTGiYE");
				toBoss.setTemplateId("ldm338MGrwekepeyQmP4_lS8nMI2T_TNTypEbTuRrCQ");
				toBoss.setUrl("ncshop.zcdreams.com/user/findOrderByOrderNo?orderNo="
						+ order.getOrderNo());
				toBoss.setTopColor("#ff0000");

				// TAddress address =new TAddress();
				// address.setAdsContent("sadas");
				// address.setAdsPhone("2312412");
				toBoss.getDatas().add(
						new WxMpTemplateData("first",
								"新订单通知", "#173177"));
				toBoss.getDatas().add(
						new WxMpTemplateData("keyword1",
								order.getOrderNo(), "#173177"));
				toBoss.getDatas().add(
						new WxMpTemplateData("keyword2", order.getOrderTime().toLocaleString(),
								"#173177"));
				toBoss.getDatas().add(
						new WxMpTemplateData("keyword3", address
								.getReceiverName(), "#173177"));
				toBoss.getDatas().add(
						new WxMpTemplateData("keyword4", address.getAdsPhone(),
								"#ff0000"));
				toBoss.getDatas().add(
						new WxMpTemplateData("keyword5", address.getAdsContent(),
								"#ff0000"));
				toBoss.getDatas().add(
						new WxMpTemplateData("remark", "点击查看订单详情，请尽快配送", "#173177"));
				System.out.println(toBoss.toJson());
				toBoss.getDatas()
						.add(new WxMpTemplateData("orderInfo", "\n" + msg,
								"#173177"));
				System.out.println(toBoss.toJson());
				wxMpService.templateSend(toBoss);

				WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content(msg)
						.fromUser(configInfo.getWeChatOriginalID())
						.toUser(user.getOpenId()).build();
			}
			if (request.getSession().getAttribute("allCost") != null) {
				request.getSession().removeAttribute("allCost");
			}
			if (request.getSession().getAttribute("odersdetails") != null) {
				request.getSession().removeAttribute("odersdetails");
			}
			response.getWriter().write("1");
		} catch (Exception e) {
			LogBuilder.writeToLog(e.getMessage());
			try {
				response.getWriter().write(e.getMessage());
			} catch (Exception e1) {
				LogBuilder.writeToLog(UserController.class.getName()
						+ e.getMessage());
				e1.printStackTrace();
			}
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
	public void bindInfo(TAddress address, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			TUser user = (TUser) request.getSession().getAttribute("user");
			if (user != null) {
				if (user.getUserId() != null) {// 老用户添加新的默认地址
					address.setUserId(user.getUserId());
					if (userService.updateAddress(user.getUserId(), address)) {
						List<TAddress> findAddress = userService
								.findAddress(user.getUserId());
						request.setAttribute("address", findAddress);
					}
				} else {// 新用户
					address.setIsDefault(true);
					userService.bind(user, address);
					List<TAddress> firstAdr = new ArrayList<TAddress>();
					firstAdr.add(address);
					request.setAttribute("address", firstAdr);
				}
			} else {
				// 本地测试进入
				address.setIsDefault(true);
				userService.bind(new TUser(), address);
				List<TAddress> addresses = new ArrayList<TAddress>();
				addresses.add(address);
				request.setAttribute("address", addresses);
			}
			request.getRequestDispatcher("/custom/MyOrder.jsp").forward(
					request, response);
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
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
				initMessageContext();
				WxMpTemplateMessage message = new WxMpTemplateMessage();

				message.setTemplateId("u9BtTXrmJlAYHbNF4YOzDNHootsjqkwljm-Krn-NzA0");
				message.setTopColor("#ff000");
				message.setToUser(user.getOpenId());
				message.getDatas()
						.add(new WxMpTemplateData("info", "订单号为"
								+ order.getOrderNo() + "的订单已受理，正在配送", "#173177"));
				wxMpService.templateSend(message);
			}
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
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

		try {
			Gson gson = null;
			Map<String, List<T>> map = new HashMap<String, List<T>>();
			map.put(t.getClass().getName().replace("com.ncshop.domain.", ""),
					list);
			try {
				finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
			return null;
		}

	}

	public void initMessageContext() {
		configDao = new ConfigDao();
		configInfo = configDao.GetConfig();
		wxMpConfigStorage = new WxMpInMemoryConfigStorage();
		wxMpConfigStorage.setAppId(configInfo.getWeChatAppID()); // 设置微信公众号的appid
		wxMpConfigStorage.setSecret(configInfo.getWeChatAppSecret()); // 设置微信公众号的app
		wxMpConfigStorage.setToken(configInfo.getWeChatToken()); // 设置微信公众号的token
		wxMpConfigStorage.setAesKey(configInfo.getWeChatAESKey()); // 设置微信公众号的EncodingAESKey
		wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

	}

	@RequestMapping("/findOrdersByUser")
	public void findOrdersByUser(String userId, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			List<TOrder> orders = userService.findOrderByeUser(userId);
			request.setAttribute("orderList", orders);
			request.getRequestDispatcher("/custom/OrderList.jsp").forward(
					request, response);
			return;
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("/findOrderByOrderNo")
	public void findOrdersByOrderNo(String orderNo, HttpServletRequest request,
			HttpServletResponse response) {

		try {
			List<TOrder> orders = userService.findOrderByeOrderNo(orderNo);
			request.setAttribute("orderList", orders);
			Set<TAddress> addresses = new HashSet<TAddress>();
			TUser user = null;
			for (TOrder tOrder : orders) {
				List<TAddress> tAddresses = userService.findAddress(tOrder
						.getUserId());
				for (TAddress tAddress : tAddresses) {
					if (tAddress.getIsDefault()) {
						addresses.add(tAddress);
						break;
					}
				}
			}
			request.getRequestDispatcher("/custom/OrderList.jsp").forward(
					request, response);
			return;
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	@RequestMapping("clearCart")
	public void clearCart(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			if (request.getSession().getAttribute("odersdetails") != null) {
				request.getSession().removeAttribute("odersdetails");
			}
			if (request.getSession().getAttribute("allCost") != null) {
				request.getSession().removeAttribute("allCost");
			}
			response.sendRedirect("/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
		}
		return;
	}

	@RequestMapping("/gotoCart")
	public void gotoCart(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			TUser user = (TUser) request.getSession().getAttribute("user");
			List<TAddress> address = null;
			if (user != null) {
				if (user.getUserId() != null) {
					address = userService.findAddress(user.getUserId());

				}
			}
			request.setAttribute("address", address);
			if (request.getSession().getAttribute("odersdetails") == null) {
				response.sendRedirect("/index.jsp");
			} else {
				request.getRequestDispatcher("/custom/MyOrder.jsp").forward(
						request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
		}

	}

	@RequestMapping("/getSellerId")
	public void getSellerId(String goodsId, HttpServletResponse response) {
		try {
			TSellergoods sellergoods = userService
					.findSellergoodsByGoodsID(Integer.parseInt(goodsId));
			Integer sellerId = sellergoods.getSeller().getSellerId();
			response.getWriter().write(sellerId + "");
		} catch (Exception e) {
			e.printStackTrace();
			LogBuilder.writeToLog(this.getClass().getName() + ":"
					+ e.getMessage());
		}

	}

	// @RequestMapping("/ajax/findOrderByOrderNo")
	// public void findOrderByOrderNoByAjax(String orderNo,
	// HttpServletResponse response) {
	// try {
	// TOrder tOrder = userService.findOrderByeOrderNo(orderNo).get(0);
	// Set<TAddress> addresses = new HashSet<TAddress>();
	// Set<TOrderdetail> orderdetails = new HashSet<TOrderdetail>();
	// TUser user = null;
	// List<TAddress> tAddresses = userService.findAddress(tOrder
	// .getUser().getUserId());
	// for (TAddress tAddress : tAddresses) {
	// if (tAddress.getIsDefault()) {
	// addresses.add(tAddress);
	// user = tOrder.getUser();
	// user.setTAddresses(addresses);
	// tOrder.setUser(user);
	// break;
	// }
	//
	// List<TOrderdetail> list = userService.findOrderdetail(tOrder
	// .getOrderId());
	// for (TOrderdetail tOrderdetail : list) {
	// orderdetails.add(tOrderdetail);
	// }
	// tOrder.setTOrderdetails(orderdetails);
	//
	// }
	// List<TOrder> orders = new ArrayList<TOrder>();
	// orders.add(tOrder);
	// String json = toJson(new TOrder(), orders, null);
	// // 设置response的传输格式为json
	// response.setContentType("application/json");
	// response.getWriter().write(json);
	// return;
	// } catch (Exception e) {
	// LogBuilder.writeToLog(UserController.class.getName()
	// + e.getMessage());
	// e.printStackTrace();
	// }
	// }
	//
	@RequestMapping("/findOrderById")
	public void findOrderById(String orderId, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			TOrder tOrder = userService.findOrderById(orderId);
			Set<TAddress> addresses = new HashSet<TAddress>();
			Set<TOrderdetail> orderdetails = new HashSet<TOrderdetail>();
			List<TOrderdetail> list = userService.findOrderdetail(tOrder
					.getOrderId());
			for (TOrderdetail tOrderdetail : list) {
				orderdetails.add(tOrderdetail);
				tOrderdetail.setTComments(null);
			}
			tOrder.setTOrderdetails(orderdetails);

			List<TOrder> orders = new ArrayList<TOrder>();
			orders.add(tOrder);
			String json = toJson(new TOrder(), orders, null);
			// 设置response的传输格式为json
			response.setContentType("application/json");
			response.getWriter().write(json);
			return;
		} catch (Exception e) {
			LogBuilder.writeToLog(UserController.class.getName()
					+ e.getMessage());
			e.printStackTrace();
		}
	}
}
