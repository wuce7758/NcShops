package com.ncshop.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncshop.dao.TAddressDAO;
import com.ncshop.dao.TGoodsDAO;
import com.ncshop.dao.TGoodstypeDAO;
import com.ncshop.dao.TOrderDAO;
import com.ncshop.dao.TOrderdetailDAO;
import com.ncshop.dao.TSellerDAO;
import com.ncshop.dao.TSellergoodsDAO;
import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TAddress;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TOrderdetail;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;
import com.ncshop.domain.TUser;
import com.ncshop.util.LogBuilder;

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
	@Autowired
	private TOrderdetailDAO orderdetailDAO;

	@SuppressWarnings("unchecked")
	public List<TSeller> findAllSellers() {
		return sellerDao.findAll();
	}

	public List<TSellergoods> findSellergoods(int sellerId, int start, int max) {
		
		TSeller seller=new TSeller();
		seller.setSellerId(sellerId);
		SimpleExpression eq1 = Restrictions.eq("seller", seller);
		SimpleExpression eq2 = Restrictions.eq("isSale", true);
		SimpleExpression[] eqs=new SimpleExpression[2];
		eqs[0]=eq1;
		eqs[1]=eq2;
		return sellergoodsDAO.getEntitiestNotLazy(new TSellergoods(),
				new String[] { "TGoods", "seller" },
				eqs, start, max, false);
	}

	public List<TGoods> findAllGoods(int start, int max) {

		return goodsDao.getEntitiestNotLazy(new TGoods(),
				new String[] { "TGoodstype" }, null, start, max, true);
	}

	public boolean order(TOrder order, Set<TOrderdetail> odersdetails) {

		try {
			orderDao.save(order);
			for (TOrderdetail tOrderdetail : odersdetails) {
				tOrderdetail.setOrderId(order.getOrderId());
				orderdetailDAO.save(tOrderdetail);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param goodstype
	 * @param sellerId
	 * @param start
	 * @param max
	 * @return
	 */
	public List<TGoods> findgoods(TGoodstype goodstype,int sellerId, int start, int max) {
		
		SimpleExpression eq1 = Restrictions.eq("TGoodstype", goodstype);
		SimpleExpression[] eqs=new SimpleExpression[2];
		eqs[1]=eq1;
		
		return goodsDao.getEntitiestNotLazy(new TGoods(),
				new String[] { "TGoodstype" },
				eqs, start, max, true);
	}

	public boolean bind(TUser user, TAddress address) {
		try {
			userDao.save(user);
			address.setUserId(user.getUserId());
			addressDAO.save(address);
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
		
		SimpleExpression[] eqs=new SimpleExpression[1];
		List<TSellergoods> list = sellergoodsDAO.getEntitiestNotLazy(
				new TSellergoods(), new String[] { "TGoods", "seller" }, null,
				0, 0, false);

		for (TSellergoods tSellergoods : list) {
			TGoods goods = tSellergoods.getTGoods();
			
			SimpleExpression eq1 = Restrictions.eq("goodsId",  goods.getGoodsId());
			eqs[0]=eq1;
			TGoods tempgGoods = goodsDao
					.getEntitiestNotLazy(new TGoods(),
							new String[] { "TGoodstype" },
							eqs, 0,
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
		
		Object []objs={userId,true};
		return addressDAO.getHibernateTemplate().find("from TAddress where userId=? and isDefault=?",objs);
	}

	public TUser findUser(String openId) {
		try {
			Object []objs={openId};
			List<TUser> list = userDao.getHibernateTemplate().find("from TUser where openId=?",objs);
			if (list.size() < 1) {
				LogBuilder.writeToLog("新用户"+openId);
				return null;
			} else {
				LogBuilder.writeToLog(list.get(0).getOpenId());
				return list.get(0);
			}
		} catch (Exception e) {
			LogBuilder.writeToLog("出错了");
			return null;
		}
		
	}

	public TSellergoods findSellergoodsByGoodsID(Integer goodsId) {
		Object [] objs={goodsId};
		TSellergoods sellergoods = (TSellergoods) sellergoodsDAO.getHibernateTemplate().find("from TSellergoods where GoodsId=?",objs).get(0);
		return sellergoods;
	}

	public TSeller findSellerByID(Integer sellerId) {
		return sellerDao.findById(sellerId);
	}

	public List<TOrder> findOrderByeUser(String userId) {
		
		Object [] objs={Integer.parseInt(userId)};
		return orderDao.getHibernateTemplate().find("from TOrder where userId=? order by orderTime desc",objs);
	}
}
