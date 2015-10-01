package com.ncshop.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncshop.dao.TSellerDAO;
import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TSeller;
import com.ncshop.domain.TSellergoods;

@Service
public class UserService {
	@Autowired
	private TUserDAO userDao;
	@Autowired
	private TSellerDAO sellerDao;

	
	@SuppressWarnings("unchecked")
	public List<TSeller> findAllSellers(){
		return sellerDao.findAll();
	}

	public Set<TSellergoods> findSellergoods(Integer sellerId) {
		// TODO Auto-generated method stub
		return sellerDao.findById(sellerId).getTSellergoodses();
	}
}
