package com.ncshop.service; 
 
 
import java.util.List;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 
 
 
import com.ncshop.dao.TGoodsDAO; 
import com.ncshop.dao.TGoodstypeDAO; 
import com.ncshop.dao.TOrderDAO; 
import com.ncshop.dao.TSellerDAO; 
import com.ncshop.dao.TSellergoodsDAO; 
import com.ncshop.dao.TUserDAO; 
import com.ncshop.domain.TGoods; 
import com.ncshop.domain.TGoodstype; 
import com.ncshop.domain.TOrder; 
import com.ncshop.domain.TSeller; 
import com.ncshop.domain.TSellergoods; 
import com.ncshop.domain.TUser; 
 
 
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncshop.dao.TGoodsDAO;
import com.ncshop.dao.TGoodstypeDAO;
import com.ncshop.dao.TOrderDAO;
import com.ncshop.dao.TSellerDAO;
import com.ncshop.dao.TSellergoodsDAO;
import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.domain.TUser;

>>>>>>> 75a53bf313521bc157ad9b3e08926e593c07f634
@Service
public class SellerService { 
	@Autowired 
	private TUserDAO userDao;
	@Autowired 
	private TSellerDAO sellerDao;
	@Autowired 
	private TSellergoodsDAO sellergoodsDao;
	@Autowired 
	private TGoodstypeDAO goodstypeDao;
	@Autowired 
	private TGoodstypeDAO goodtypeDao;
<<<<<<< HEAD
	@Autowired 
	private TGoodsDAO goodsDao;
	@Autowired 
	private TOrderDAO orderDao;
 
 
=======
	@Autowired
	private TGoodsDAO goodsDao;
	@Autowired
	private TOrderDAO orderDao;

>>>>>>> 75a53bf313521bc157ad9b3e08926e593c07f634
	public List<TOrder> findSellerOrder(int openId, int orderState) {
		// TODO Auto-generated method stub 
		return null; 
	} 
 
 
	public void addGoods(int sellerId,int goodsTypeId,TGoods goods) {
		// TODO Auto-generated method stub 
		TSeller seller=sellerDao.findById(sellerId);
		TGoodstype goodsType=goodstypeDao.findById(goodsTypeId);
		TSellergoods sellergoods=new TSellergoods();
		goods.setTGoodstype(goodsType);
		sellergoods.setTGoods(goods);
<<<<<<< HEAD
		sellergoods.setSellerId(sellerId);
=======
		sellergoods.setTSeller(seller);
>>>>>>> 75a53bf313521bc157ad9b3e08926e593c07f634
		goodsDao.save(goods);
		sellergoodsDao.save(sellergoods);
	} 
 
 
	public void addGoodsType(TGoodstype goodsType) {
		// TODO Auto-generated method stub 
		goodtypeDao.save(goodsType);
<<<<<<< HEAD
	} 
 
 
	public void limitUser(int userId) {
		// TODO Auto-generated method stub 
		TUser user=userDao.findById(userId);
		if(user.getUserState()==true){
			user.setUserState(false);
		}else{ 
			user.setUserState(true);
		} 
		 
	} 
	//修改商品信息 
	public void updateGoods(int goodsTypeId, TGoods goods) {
		// TODO Auto-generated method stub 
=======
	}

	public void limitUser(int userId) {
		// TODO Auto-generated method stub
		TUser user=userDao.findById(userId);
		if(user.getUserState()==true){
			user.setUserState(false);
		}else{
			user.setUserState(true);
		}
		
	}
	//修改商品信息
	public void updateGoods(int goodsTypeId, TGoods goods) {
		// TODO Auto-generated method stub
>>>>>>> 75a53bf313521bc157ad9b3e08926e593c07f634
		TGoodstype goodsType=goodstypeDao.findById(goodsTypeId);
		TGoods gs=goodsDao.findById(goods.getGoodsId());
		gs.setGoodsMsg(goods.getGoodsMsg());
		gs.setGoodsName(goods.getGoodsName());
		gs.setGoodsPic(goods.getGoodsPic());
		gs.setGoodsPrice(goods.getGoodsPrice());
		gs.setTGoodstype(goodsType);
		goodsDao.save(gs);
<<<<<<< HEAD
	} 
 
 
	public TOrder changeOrderState(int orderId, int orderState) {
		// TODO Auto-generated method stub 
=======
	}

	public TOrder changeOrderState(int orderId, int orderState) {
		// TODO Auto-generated method stub
>>>>>>> 75a53bf313521bc157ad9b3e08926e593c07f634
		TOrder order=orderDao.findById(orderId);
		order.setOrderState(orderState);
		orderDao.save(order);
		return order;
<<<<<<< HEAD
	} 
} 
=======
	}
}
>>>>>>> 75a53bf313521bc157ad9b3e08926e593c07f634
