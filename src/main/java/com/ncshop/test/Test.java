package com.ncshop.test;


import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncshop.dao.TAddressDAO;
import com.ncshop.dao.TGoodsDAO;
import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TAddress;
import com.ncshop.domain.TUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test{

	@Resource(name="TUserDAO")
	private TUserDAO userDAO;
	@Resource(name="TAddressDAO")
	private TAddressDAO addressDAO;
	
	
	@org.junit.Test
	public void test1() {
		TUser user=new TUser();
		user.setUserName("xiao");
		user.setIsAttention(true);
		user.setOpenId("sssssss");
		user.setSex("男");
		user.setTelNumber("15879023814");
		userDAO.save(user);
		userDAO.findAll();
		
	}
	@org.junit.Test
	public void testMenu(){
		
		new BuildMenu().setConfig().build();
	}
	@org.junit.Test
	public void test(){
		TGoodsDAO tGoodsDAO = new TGoodsDAO();
		List findAll = tGoodsDAO.findAll();
		System.out.println("");
	}
}
