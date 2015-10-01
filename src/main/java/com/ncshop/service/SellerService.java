package com.ncshop.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncshop.dao.TSellerDAO;
import com.ncshop.dao.TSellergoodsDAO;
import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TOrder;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;

@Service
public class SellerService {
	@Autowired
	private TUserDAO userDao;
	@Autowired
	private TSellerDAO uellerDao;

	public List<TOrder> findSellerOrder(int openId, int orderState) {
		// TODO Auto-generated method stub
		return null;
	}

	public int addGoods(TSellergoods sellergoods) {
		// TODO Auto-generated method stub
		return 0;
	}
}
