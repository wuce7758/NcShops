package com.ncshop.service;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncshop.dao.TGoodsDAO;
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

@Service
public class UserService {
	@Autowired
	private TUserDAO userDao;
	@Autowired
	private TSellerDAO sellerDao;
	@Autowired
	private TGoodsDAO goodsDao;
	@Autowired
	private TOrderDAO orderDao;
	private TSellergoodsDAO sellergoodsDAO;

	
	@SuppressWarnings("unchecked")
	public List<TSeller> findAllSellers(){
		return sellerDao.findAll();
	}

	public List<TSellergoods> findSellergoods(TSeller seller) {
		return sellergoodsDAO.getEntitiestNotLazy(new TSellergoods(), new String []{"TGoods","TSeller"}, Restrictions.eq("TSeller", seller));
	}

	public List<TGoods> findAllGoods() {
		
		return goodsDao.getEntitiestNotLazy(new TGoods(), new String[]{"TGoodstype"}, null);
	}

	public boolean order(TOrder order) {
		
		try {
			orderDao.save(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<TGoods> findgoods(TGoodstype goodstype) {
		return goodsDao.getEntitiestNotLazy(new TGoods(), new String[]{"TGoodstype"}, Restrictions.eq("TGoodstype", goodstype));
	}

	public List<TSellergoods> findSellergood(TSellergoods sellergoods) {
		return sellergoodsDAO.getEntitiestNotLazy(new TSellergoods(), new String []{"TGoods","TSeller"}, Restrictions.eq("TSellergoods", sellergoods));
	}

	public boolean bind(TUser user) {
		try {
			userDao.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
