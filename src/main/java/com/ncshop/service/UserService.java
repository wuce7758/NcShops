package com.ncshop.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncshop.dao.TAddressDAO;
import com.ncshop.dao.TGoodsDAO;
import com.ncshop.dao.TGoodstypeDAO;
import com.ncshop.dao.TOrderDAO;
import com.ncshop.dao.TSellerDAO;
import com.ncshop.dao.TSellergoodsDAO;
import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TAddress;
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
	@Autowired
	private TSellergoodsDAO sellergoodsDAO;
	@Autowired
	private TGoodstypeDAO goodstypeDAO;
	@Autowired
	private TAddressDAO addressDAO;

	@SuppressWarnings("unchecked")
	public List<TSeller> findAllSellers() {
		return sellerDao.findAll();
	}

	public List<TSellergoods> findSellergoods(TSeller seller) {
		return sellergoodsDAO.getEntitiestNotLazy(new TSellergoods(),
				new String[] { "TGoods", "TSeller" },
				Restrictions.eq("TSeller", seller), 0, 0, false);
	}

	public List<TGoods> findAllGoods(int start, int max) {

		return goodsDao.getEntitiestNotLazy(new TGoods(),
				new String[] { "TGoodstype" }, null, start, max, true);
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

	public List<TGoods> findgoods(TGoodstype goodstype, int start, int max) {
		return goodsDao.getEntitiestNotLazy(new TGoods(),
				new String[] { "TGoodstype" },
				Restrictions.eq("TGoodstype", goodstype), start, max, true);
	}

	public List<TSellergoods> findSellergood(TSellergoods sellergoods) {
		return sellergoodsDAO.getEntitiestNotLazy(new TSellergoods(),
				new String[] { "TGoods", "TSeller" },
				Restrictions.eq("TSellergoods", sellergoods), 0, 0, false);
	}

	public boolean bind(TUser user, TAddress address) {
		try {
			user.getTAddresses().add(address);
			userDao.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TGoods findgoodsById(String goodId) {
		return goodsDao.findById(Integer.parseInt(goodId));
	}

	public TOrder findOrderById(String orderId) {
		return orderDao.findById(Integer.parseInt(orderId));
	}

	public TUser findUserById(int userid) {
		return userDao.findById(userid);
	}

	public boolean upadateOrder(String orderId) {
		return orderDao.update(orderId);
	}

	public List<TSellergoods> findGoodsdetail() {
		List<TSellergoods> list = sellergoodsDAO.getEntitiestNotLazy(
				new TSellergoods(), new String[] { "TGoods", "seller" }, null,
				0, 0, false);

		for (TSellergoods tSellergoods : list) {
			TGoods goods = tSellergoods.getTGoods();
			TGoods tempgGoods = goodsDao
					.getEntitiestNotLazy(new TGoods(),
							new String[] { "TGoodstype" },
							Restrictions.eq("goodsId", goods.getGoodsId()), 0,
							0, false).get(0);
			tSellergoods.setTGoods(tempgGoods);
			TGoodstype findById = goodstypeDAO.findById(goods.getGoodsId());
			goods.setTGoodstype(findById);
			tSellergoods.setTGoods(goods);
		}
		return list;
	}

	public boolean updateAddress(Integer userId, TAddress address) {

		try {
			List<TAddress> findAll = findAddress(userId);
			// 获取用户的所有地址
			for (TAddress tAddress : findAll) {

				// 将原来的默认地址取消
				if (tAddress.getIsDefault()) {
					addressDAO.update(tAddress.getAddressId());
				}
				// 如果改地址已存在
				if (address.equals(tAddress)) {
					// 设为默认地址
					addressDAO.updateTODefault(tAddress.getAddressId());
				}
			}

			address.setIsDefault(true);
			addressDAO.save(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<TAddress> findAddress(Integer userId) {

		return addressDAO.getHibernateTemplate().find("from TAddress where userId="+userId+" and isDefault="+true);
	}

	public TUser findUser(String openId) {
		List<TUser> list = userDao.getHibernateTemplate().find("from TUser where openId='"+openId+"'");
		if (list.size() < 1) {
			return null;
		} else {
			return list.get(0);
		}
	}
}
