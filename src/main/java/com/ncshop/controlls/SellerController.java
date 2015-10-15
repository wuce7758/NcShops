package com.ncshop.controlls;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.service.SellerService;
import com.ncshop.service.UserService;
import com.ncshop.util.TargetStrategy;

@Controller
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;

	/**
	 * 用户登陆
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void sellerLogin(HttpServletRequest request,HttpServletResponse response,String sellerName,String sellerPhone) throws ServletException, IOException{
		if(sellerName=="admin123"&&sellerPhone=="123"){
			TSeller seller=sellerService.sellerLogin(sellerName,sellerPhone);
			request.getSession().setAttribute("seller", seller);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.getSession().setAttribute("sellerName", "用户名错误！");
			request.getSession().setAttribute("sellerPassword", "用户名密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	/**
	 * 根据订单状态和微信标识查找某店铺订单
	 * @param sellerId
	 * @param orderState 订单状态
	 * @throws Exception
	 */
	@RequestMapping("/findSellerOrders")
	public void findSellerOrders(HttpServletResponse response, int sellerId,
			int orderState) throws Exception {
		if (sellerId + "" == "" || orderState + "" == "") {
			return;
		}
		// 调用service查找 数据库
		List<TOrder> orderList = sellerService.findSellerOrder(sellerId,
				orderState);
		String json=toJson(new TOrder(),orderList,null);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write(json);
	}

	/**
	 * 操作店铺商品
	 * @param sellerId 卖家唯一标识
	 * @param goods 新商品
	 * @throws Exception
	 */
	@RequestMapping("/addGoods")
	public void addGoods(HttpServletResponse response, int sellerId,String oper,
			int goodsTypeId, TGoods goods) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		// 调用service查找 数据库
		if(oper=="add"){
			if(sellerId + "" == "" || goodsTypeId + "" == ""){
				return;
			}
			sellerService.addGoods(sellerId, goodsTypeId, goods);
			response.getWriter().write("添加商品成功!");
		}else if(oper=="edit"){
			if(sellerId + "" == "" || goodsTypeId + "" == ""){
				return;
			}
			sellerService.updateGoods(goodsTypeId, goods);
			response.getWriter().write("修改商品成功!");
		}else if(oper=="del"){
			sellerService.deleteGoods(goods);
			response.getWriter().write("删除商品成功!");
		}
	}
	
	/**
	 * 商品下架、上架状态
	 * @param sellerId 卖家唯一标识
	 * @param goods 新商品
	 * @throws Exception
	 */
	@RequestMapping("/updownGoods")
	public void updownGoods(HttpServletResponse response,int goodsId,boolean isSale) throws Exception {
		if (goodsId + "" == ""&&isSale+""!="") {
			return;
		}
		// 调用service查找 数据库
		sellerService.downGoods(goodsId,isSale);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("商品下架成功!");
	}

	/**
	 * 添加商品类型
	 * @param goodsType商品类型对象
	 * @throws Exception
	 */
	@RequestMapping("/addGoodsType")
	public void addGoodsType(HttpServletResponse response, TGoodstype goodsType)
			throws Exception {
		String goodsTypeName = goodsType.getGoodsTypeName();
		if (goodsTypeName == null || goodsTypeName == "") {
			return;
		}
		// 调用service查找 数据库
		sellerService.addGoodsType(goodsType);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write("添加商品类型成功!");
	}
	
	/**
	 * 获取所有商品类型
	 * @throws Exception
	 */
	@RequestMapping("/getAllGoodsType")
	public void getAllGoodsType(HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TGoodstype> list=sellerService.getAllGoodsType();
		String json=toJson(new TGoodstype(),list,null);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
	
	/**
	 * 将集合转换成json
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
}
