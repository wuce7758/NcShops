package com.ncshop.test;


import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncshop.dao.TAddressDAO;
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
		user.setUserName("xiaolong");
		userDAO.save(user);
		userDAO.findAll();
		
	}
	@org.junit.Test
	public void test2() {
		TAddress address=new TAddress();
		address.setAdsContent("xxxx");
		//address.setTUser(userDAO.findById(1));
		address.setAdsPhone("15879023814");
		addressDAO.save(address);	
	}
	@org.junit.Test
	public void testMenu(){
		
		new BuildMenu().setConfig().build();
	}
}
