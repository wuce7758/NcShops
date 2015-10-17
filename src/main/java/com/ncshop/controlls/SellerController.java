package com.ncshop.controlls;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.service.SellerService;
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
	@RequestMapping("/sellerLogin")
	public void sellerLogin(HttpServletRequest request,HttpServletResponse response,String sellerName,String sellerPhone) throws ServletException, IOException{
		//if(sellerName=="admin123"&&sellerPhone=="123"){
			//TSeller seller=sellerService.sellerLogin(sellerName,sellerPhone);
			List<TGoods> list= sellerService.findAllGoods();
			request.setAttribute("allGoods",list);
			//request.getSession().setAttribute("seller", seller);
			request.getRequestDispatcher("/admin/page/goods.jsp").forward(request, response);
		//}else{
			//request.getSession().setAttribute("sellerName", "用户名错误！");
			//request.getSession().setAttribute("sellerPassword", "用户名密码错误！");
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
		//}
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
	 * 添加商家

	 * @throws Exception
	 */
	@RequestMapping("/addSeller")
	public void addSeller(HttpServletResponse response, TSeller seller) throws Exception {
		// 调用service查找 数据库
		seller.setIsValid(true);
		sellerService.addSeller(seller);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 操作店铺商品
	 * @param sellerId 卖家唯一标识
	 * @param goods 新商品
	 * @throws Exception
	 */
	@RequestMapping("/addGoods")
	public void addGoods(HttpServletRequest request,HttpServletResponse response,
			String sellerId,String goodsTypeId,MultipartFile pic,String oper,TGoods goods) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		if(sellerId+""==""||goodsTypeId+""==""){
			return;
		}
		//定义物理路径
		String basePath=request.getRealPath("/")+"images\\";
		System.out.println(basePath);
		File f=new File(basePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		if(pic!=null){
			//旧文件名
			String fileName=pic.getOriginalFilename();
			//新文件名
			String newFileName=new Date().getTime()+fileName.substring(fileName.lastIndexOf("."));
			File file=new File(basePath+newFileName);
			//将文件保存到硬盘
			pic.transferTo(file);
			//重新设置图片名
			goods.setGoodsPic(newFileName);
			//调用service查找 数据库
		}else{
			//设置默认图片
			goods.setGoodsPic("default.jpg");
		}
		// 调用service查找 数据库
		if(oper.equals("add")){
			if(sellerId==""||goodsTypeId + "" == ""){
				return;
			}
			sellerService.addGoods(Integer.parseInt(sellerId), Integer.parseInt(goodsTypeId), goods);
			response.getWriter().write("1");
		}else if(oper.equals("edit")){
			if(sellerId + "" == "" || goodsTypeId + "" == ""){
				return;
			}
			sellerService.updateGoods(Integer.parseInt(goodsTypeId), goods);
			response.getWriter().write("1");
		}else if(oper.equals("delete")){
			sellerService.deleteGoods(goods);
			response.getWriter().write("1");
		}else{
			response.getWriter().write("表单填写不完整！");
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
		response.getWriter().write("1");
	}
	
	/**
	 * 改变商家状态
	 * @throws Exception
	 */
	@RequestMapping("/updownSeller")
	public void updownSeller(HttpServletResponse response,int sellerId,boolean isValid) throws Exception {
		if (sellerId + "" == ""&&isValid+""!="") {
			return;
		}
		// 调用service查找 数据库
		sellerService.updownSeller(sellerId,isValid);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}
	
	/**
	 * 改变订单状态
	 * @throws Exception
	 */
	@RequestMapping("/changeOrderState")
	public void changeOrderState(HttpServletResponse response,int orderId,int orderState) throws Exception {
		if (orderId + "" == ""&&orderState+""!="") {
			return;
		}
		// 调用service操作数据库
		sellerService.changeOrderState(orderId,orderState);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
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
	 * 获取所有商家	json方式
	 * @throws Exception
	 */
	@RequestMapping("/getAllSeller")
	public void getAllSeller(HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TSeller> list=sellerService.getAllSeller();
		String json=toJson(new TSeller(),list,null);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
	
	/**
	 * 获取所有商家	转发方式
	 * @throws Exception
	 */
	@RequestMapping("/findAllSeller")
	public void findAllSeller(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TSeller> list=sellerService.getAllSeller();
		request.setAttribute("sellerList", list);
		request.getRequestDispatcher("/admin/page/store.jsp").forward(request,
				response);
	}
	/**
	 * 获取所有订单信息 转发方式
	 * @throws Exception
	 */
	@RequestMapping("/findAllOrder")
	public void findAllOrder(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TOrder> list=sellerService.findAllOrder();
		request.setAttribute("orderList", list);
		String json=toJson(new TOrder(),list,null);
		request.getRequestDispatcher("/admin/page/order.jsp").forward(request,response);
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
