package com.ncshop.test;


import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncshop.dao.TUserDAO;
import com.ncshop.domain.TUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test{

	@Resource(name="TUserDAO")
	private TUserDAO userDAO;
	
	
	@org.junit.Test
	public void test1() {
		TUser user=new TUser();
		user.setUserName("xiaolong");
		userDAO.save(user);
		userDAO.findAll();
		
	}
}
