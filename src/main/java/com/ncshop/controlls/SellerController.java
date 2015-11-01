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
import com.ncshop.domain.TAds;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.domain.TUser;
import com.ncshop.service.SellerService;
import com.ncshop.service.UserService;
import com.ncshop.util.CompressPicUtil;
import com.ncshop.util.TargetStrategy;

@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;
	@Autowired
	private UserService userService;

	/**
	 * 用户登陆
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("/sellerLogin")
	public void sellerLogin(HttpServletRequest request,
			HttpServletResponse response, String sellerName, String sellerPhone)
			throws ServletException, IOException {
		if (sellerName.equals("admin") && sellerPhone.equals("zyhyxsk321@")) {
			List<TSellergoods> list = userService.findGoodsdetail();
			request.setAttribute("goodDetail", list);
			request.getSession().setAttribute("seller", "login");
			request.getRequestDispatcher("/admin/page/goods.jsp").forward(
					request, response);
		} else {
			request.getSession().setAttribute("sellerName", "用户名错误！");
			request.getSession().setAttribute("sellerPassword", "用户名密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
		}
	}

	/**
	 * 根据商家ID、订单状态查找某店铺订单
	 * 
	 * @param sellerId
	 * @param orderState订单状态
	 * @throws Exception
	 */
	@RequestMapping("/seller/findSellerOrders")
	public void findSellerOrders(HttpServletResponse response, int sellerId,
			int orderState) throws Exception {
		if (sellerId + "" == "" || orderState + "" == "") {
			return;
		}
		// 调用service查找 数据库
		List<TOrder> orderList = sellerService.findSellerOrder(sellerId,
				orderState);
		String json = toJson(new TOrder(), orderList, null);
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().write(json);
	}

	/**
	 * 添加商家
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/seller/addSeller")
	public void addSeller(HttpServletRequest request,
			HttpServletResponse response, TSeller seller, String oper,
			MultipartFile pic) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		// 定义物理路径
		String basePath = request.getRealPath("/") + "images\\";
		String tempPath = request.getRealPath("/") + "temp\\";
		System.out.println(basePath);
		File f = new File(tempPath);
		File f2 = new File(basePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		if (!f2.exists()) {
			f2.mkdirs();
		}
		if (pic != null) {
			// 旧文件名
			String fileName = pic.getOriginalFilename();
			// 新文件名
			String newFileName = new Date().getTime()
					+ fileName.substring(fileName.lastIndexOf("."));
			File file = new File(tempPath + newFileName);
			// 将文件保存到硬盘
			pic.transferTo(file);

			CompressPicUtil mypic = new CompressPicUtil();
			mypic.compressPic(tempPath, basePath, newFileName, newFileName,
					120, 120, true);
			if (file.delete()) {
				System.out.println("delete success");
			}
			// 重新设置图片名
			seller.setShopPic(newFileName);
			// 调用service查找 数据库
		} else {
			// 设置默认图片
			seller.setShopPic("default.jpg");
		}
		seller.setIsValid(true);
		// 调用service查找 数据库
		if (oper.equals("add")) {
			sellerService.addSeller(seller);
			response.getWriter().write("1");
		} else if (oper.equals("modify")) {
			sellerService.updateSeller(seller);
			response.getWriter().write("1");
		} else if (oper.equals("delete")) {
			sellerService.deleteSeller(seller);
			response.getWriter().write("1");
		} else {
			response.getWriter().write("表单填写不完整！");
		}
	}

	/**
	 * 操作店铺商品
	 * 
	 * @param sellerId
	 *            卖家唯一标识
	 * @param goods
	 *            新商品
	 * @throws Exception
	 */
	@RequestMapping("/seller/addGoods")
	public void addGoods(HttpServletRequest request,
			HttpServletResponse response, String sellerId, String goodsTypeId,
			MultipartFile pic, String oper, TGoods goods) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		if (sellerId + "" == "" || goodsTypeId + "" == "") {
			return;
		}
		// 定义物理路径
		String basePath = request.getRealPath("/") + "images\\";
		String tempPath = request.getRealPath("/") + "temp\\";
		System.out.println(basePath);
		File f = new File(tempPath);
		File f2 = new File(basePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		if (!f2.exists()) {
			f2.mkdirs();
		}
		if (pic != null) {
			// 旧文件名
			String fileName = pic.getOriginalFilename();
			// 新文件名
			String newFileName = new Date().getTime()
					+ fileName.substring(fileName.lastIndexOf("."));
			File file = new File(tempPath + newFileName);
			// 将文件保存到硬盘
			pic.transferTo(file);

			CompressPicUtil mypic = new CompressPicUtil();
			mypic.compressPic(tempPath, basePath, newFileName, newFileName,
					120, 120, true);
			if (file.delete()) {
				System.out.println("delete success");
			}
			// 重新设置图片名
			goods.setGoodsPic(newFileName);
			// 调用service查找 数据库
		} else {
			// 设置默认图片
			goods.setGoodsPic("default.jpg");
		}
		// 调用service查找 数据库
		if (oper.equals("add")) {
			if (sellerId == "" || goodsTypeId + "" == "") {
				return;
			}
			sellerService.addGoods(Integer.parseInt(sellerId),
					Integer.parseInt(goodsTypeId), goods);
			response.getWriter().write("1");
		} else if (oper.equals("modify")) {
			if (sellerId + "" == "" || goodsTypeId + "" == "") {
				return;
			}
			sellerService.updateGoods(Integer.parseInt(goodsTypeId), goods);
			response.getWriter().write("1");
		} else if (oper.equals("delete")) {
			sellerService.deleteGoods(goods);
			response.getWriter().write("1");
		} else {
			response.getWriter().write("表单填写不完整！");
		}
	}

	/**
	 * 操作广告
	 * 
	 * @param sellerId
	 *            卖家唯一标识
	 * @param goods
	 *            新商品
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/seller/addAds")
	public void addAds(HttpServletRequest request,
			HttpServletResponse response, String adsId, MultipartFile pic,
			String oper, TAds ads) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		if (adsId + "" == "") {
			return;
		}
		// 定义物理路径
		String basePath = request.getRealPath("/") + "images\\";
		String tempPath = request.getRealPath("/") + "temp\\";
		System.out.println(basePath);
		File f = new File(tempPath);
		File f2 = new File(basePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		if (!f2.exists()) {
			f2.mkdirs();
		}
		if (pic != null) {
			// 旧文件名
			String fileName = pic.getOriginalFilename();
			// 新文件名
			String newFileName = new Date().getTime()
					+ fileName.substring(fileName.lastIndexOf("."));
			File file = new File(tempPath + newFileName);
			// 将文件保存到硬盘
			pic.transferTo(file);

			CompressPicUtil mypic = new CompressPicUtil();
			mypic.compressPic(tempPath, basePath, newFileName, newFileName,
					600, 600, true);
			if (file.delete()) {
				System.out.println("delete success");
			}
			// 重新设置图片名
			ads.setAdsPic(newFileName);
			// 调用service查找 数据库
		} else {
			// 设置默认图片
			ads.setAdsPic("default.jpg");
		}
		// 调用service查找 数据库
		if (oper.equals("add")) {
			sellerService.addAds(ads);
			response.getWriter().write("1");
		} else if (oper.equals("modify")) {
			sellerService.updateAds(ads);
			response.getWriter().write("1");
		} else if (oper.equals("delete")) {
			// sellerService.deleteAds(ads);
			// response.getWriter().write("1");
		} else {
			response.getWriter().write("表单填写不完整！");
		}
	}

	/**
	 * 改变商品状态
	 * 
	 * @param sellerId
	 *            卖家唯一标识
	 * @param goods
	 *            新商品
	 * @throws Exception
	 */
	@RequestMapping("/seller/updownGoods")
	public void updownGoods(HttpServletResponse response, int goodsId,
			boolean isSale) throws Exception {
		if (goodsId + "" == "" && isSale + "" != "") {
			return;
		}
		// 调用service查找 数据库
		sellerService.updownGoods(goodsId, isSale);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 改变商家状态
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/updownSeller")
	public void updownSeller(HttpServletResponse response, int sellerId,
			boolean isValid) throws Exception {
		if (sellerId + "" == "" && isValid + "" != "") {
			return;
		}
		// 调用service查找 数据库
		sellerService.updownSeller(sellerId, isValid);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 改变广告状态
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/updownAds")
	public void updownAds(HttpServletResponse response, int adsId,
			boolean isValid) throws Exception {
		if (adsId + "" == "" && isValid + "" != "") {
			return;
		}
		// 调用service查找 数据库
		sellerService.updownAds(adsId, isValid);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}
	
	/**
	 * 改变广告状态
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/updownGoodsType")
	public void updownGoodsType(HttpServletResponse response, int goodsTypeId,
			boolean isValid) throws Exception {
		if (goodsTypeId + "" == "" && isValid + "" != "") {
			return;
		}
		// 调用service查找 数据库
		sellerService.updownGoodsType(goodsTypeId, isValid);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 改变订单状态
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/changeOrderState")
	public void changeOrderState(HttpServletResponse response, int orderId,
			int orderState) throws Exception {
		if (orderId + "" == "" && orderState + "" != "") {
			return;
		}
		// 调用service操作数据库
		sellerService.changeOrderState(orderId, orderState);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 添加商品类型
	 * 
	 * @param goodsType
	 *            商品类型对象
	 * @throws Exception
	 */
	@RequestMapping("/seller/addGoodsType")
	public void addGoodsType(HttpServletRequest request,
			HttpServletResponse response, String goodsTypeId, MultipartFile pic,
			String oper, TGoodstype goodsType) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		if (goodsTypeId + "" == "") {
			return;
		}
		// 定义物理路径
		String basePath = request.getRealPath("/") + "images\\";
		String tempPath = request.getRealPath("/") + "temp\\";
		System.out.println(basePath);
		File f = new File(tempPath);
		File f2 = new File(basePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		if (!f2.exists()) {
			f2.mkdirs();
		}
		if (pic != null) {
			// 旧文件名
			String fileName = pic.getOriginalFilename();
			// 新文件名
			String newFileName = new Date().getTime()
					+ fileName.substring(fileName.lastIndexOf("."));
			File file = new File(tempPath + newFileName);
			// 将文件保存到硬盘
			pic.transferTo(file);

			CompressPicUtil mypic = new CompressPicUtil();
			mypic.compressPic(tempPath, basePath, newFileName, newFileName,
					120, 120, true);
			if (file.delete()) {
				System.out.println("delete success");
			}
			// 重新设置图片名
			goodsType.setGoodsTypeImg(newFileName);
			// 调用service查找 数据库
		} else {
			// 设置默认图片
			goodsType.setGoodsTypeImg("default.jpg");
		}
		// 调用service查找 数据库
		if (oper.equals("add")) {
			sellerService.addGoodsType(goodsType);
			response.getWriter().write("1");
		} else if (oper.equals("modify")) {
			sellerService.updateGoodsType(goodsType);
			response.getWriter().write("1");
		} else if (oper.equals("delete")) {
			// sellerService.deleteAds(ads);
			// response.getWriter().write("1");
		} else {
			response.getWriter().write("表单填写不完整！");
		}
	}

	/**
	 * 获取所有商品类型 JSON
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/getAllGoodsType")
	public void getAllGoodsType(HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TGoodstype> list = sellerService.getAllGoodsType();
		String json = toJson(new TGoodstype(), list, null);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * 通过用户Id查找用户信息 JSON
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/getUserById")
	public void getUserById(HttpServletResponse response, int userId)
			throws Exception {
		// 调用service查找 数据库
		List<TUser> list = sellerService.getUserById(userId);
		
		for (TUser tUser : list) {
			tUser.setTOrders(null);
			tUser.setTComments(null);
		}
		String json = toJson(new TUser(), list, null);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * 通过商家Id查找商家
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/getSellerById")
	public void getSellerById(HttpServletResponse response, int sellerId)
			throws Exception {
		// 调用service查找 数据库
		List<TSeller> list = sellerService.getSellerById(sellerId);
		String json = toJson(new TSeller(), list, null);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * 获取所有商家 json方式
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/getAllSeller")
	public void getAllSeller(HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TSeller> list = sellerService.getAllSellerByState();
		String json = toJson(new TSeller(), list, null);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * 获取所有商家 转发方式
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/findAllSeller")
	public void findAllSeller(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TSeller> list = sellerService.getAllSeller();
		request.setAttribute("sellerList", list);
		request.getRequestDispatcher("/admin/page/store.jsp").forward(request,
				response);
	}
	
	/**
	 * 获取所有商家 转发方式
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/findAllGoodsType")
	public void findAllGoodsType(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TGoodstype> list = sellerService.findAllGoodsType();
		request.setAttribute("typeList", list);
		request.getRequestDispatcher("/admin/page/goodsType.jsp").forward(request,
				response);
	}

	/**
	 * 获取所有广告 转发方式
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/findAllAds")
	public void findAllAds(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<TAds> list = sellerService.getAllAds();
		request.setAttribute("adsList", list);
		request.getRequestDispatcher("/admin/page/ads.jsp").forward(request,
				response);
	}

	/**
	 * 获取所有订单信息 转发方式
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/seller/findAllOrder")
	public void findAllOrder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 调用service查找 数据库
		List<TOrder> list = sellerService.findAllOrder();
		request.setAttribute("orderList", list);
		request.getRequestDispatcher("/admin/page/order.jsp").forward(request,
				response);
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
		return json;
	}
}
