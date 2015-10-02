package com.ncshop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncshop.dao.TGoodstypeDAO;
import com.ncshop.dao.TSellerDAO;
import com.ncshop.dao.TSellergoodsDAO;
import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TGoods;
import com.ncshop.domain.TGoodstype;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;

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
		sellergoods.setTSeller(seller);
		
		sellergoodsDao.save(sellergoods);
	}

	public void addGoodsType(TGoodstype goodsType) {
		// TODO Auto-generated method stub
		goodtypeDao.save(goodsType);
	}
}
