package com.ncshop.controlls;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
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
	 * 更改订单状态，比如订单完成
	 * @param response
	 * @param orderId
	 * @param orderState
	 * @throws IOException 
	 */
	@RequestMapping("/changeOrderState")
	public void changeOrderState(HttpServletResponse response,int orderId,int orderState) throws IOException{
		if(orderId+""==""||orderState+""==""){
			return;
		}
		TOrder order=sellerService.changeOrderState(orderId,orderState);
		if(order!=null){
			response.setContentType("html/text;charset=utf-8");
			response.getWriter().write("添加商品成功!");			
		}
	}
	/**
	 * 添加店铺商品
	 * @param sellerId 卖家唯一标识
	 * @param goods 新商品
	 * @throws Exception
	 */
	@RequestMapping("/addGoods")
	public void addGoods(HttpServletResponse response,
			int sellerId,int goodsTypeId,
			MultipartFile picFile, TGoods goods) throws Exception{	
		if(sellerId+""==""||goodsTypeId+""==""){
			return;
		}
		//定义物理路径
		String basePath="C:\\fileupload\\goodspic\\"+goodsTypeId+"\\";
		File f=new File(basePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		if(picFile!=null){
			//旧文件名
			String fileName=picFile.getOriginalFilename();
			//新文件名
			String newFileName=new Date().getTime()+fileName.substring(fileName.lastIndexOf("."));
			File file=new File(basePath+newFileName);
			//将文件保存到硬盘
			picFile.transferTo(file);
			//重新设置图片名
			goods.setGoodsPic(newFileName);
			//调用service查找 数据库
		}else{
			//设置默认图片
			goods.setGoodsPic("default.jpg");
		}
		sellerService.addGoods(sellerId,goodsTypeId,goods);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("添加商品成功!");
	}
	/**
	 * 修改商品信息
	 * @param response
	 * @param sellerId
	 * @param goodsTypeId
	 * @param picFile
	 * @param goods
	 * @throws Exception
	 */
	@RequestMapping("/updateGoods")
	public void updateGoods(HttpServletResponse response,
			int goodsTypeId,
			MultipartFile picFile, TGoods goods) throws Exception{	
		if(goodsTypeId+""==""){
			return;
		}
		//定义物理路径
		String basePath="C:\\fileupload\\goodspic\\"+goodsTypeId+"\\";
		File f=new File(basePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		if(picFile!=null){
			//旧文件名
			String fileName=picFile.getOriginalFilename();
			//新文件名
			String newFileName=new Date().getTime()+fileName.substring(fileName.lastIndexOf("."));
			File file=new File(basePath+newFileName);
			//将文件保存到硬盘
			picFile.transferTo(file);
			//重新设置图片名
			goods.setGoodsPic(newFileName);
			//调用service查找 数据库
		}else{
			//设置默认图片
			goods.setGoodsPic("default.jpg");
		}
		sellerService.updateGoods(goodsTypeId,goods);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("商品修改成功!");
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
	 * @param userId 
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
